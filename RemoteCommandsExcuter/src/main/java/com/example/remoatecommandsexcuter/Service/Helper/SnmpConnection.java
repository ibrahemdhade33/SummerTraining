package com.example.remoatecommandsexcuter.Service.Helper;


import org.snmp4j.CommunityTarget;

import lombok.NoArgsConstructor;

import org.snmp4j.Snmp;
import org.snmp4j.Target;
import org.snmp4j.TransportMapping;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.*;
import org.snmp4j.transport.DefaultUdpTransportMapping;
import org.snmp4j.util.DefaultPDUFactory;
import org.snmp4j.util.TreeEvent;
import org.snmp4j.util.TreeUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
@NoArgsConstructor
@Service
public class SnmpConnection {

    public CommunityTarget<Address> creatConnection(String hostIp){
        //create the connection
        CommunityTarget<Address> target = new CommunityTarget<>();
        //put your community name
        target.setCommunity(new OctetString("public"));
        //put your host ip
        target.setAddress(GenericAddress.parse("udp:"+hostIp+"/161")); // supply your own IP and port
        target.setRetries(2);
        target.setTimeout(1500);
        target.setVersion(SnmpConstants.version2c);
        return target ;
    }
    public  Map<String, String> doWalk(String tableOid, Target<Address> target) throws IOException {
        Map<String, String> result = new TreeMap<>();
        TransportMapping<? extends Address> transport = new DefaultUdpTransportMapping();
        Snmp snmp = new Snmp(transport);
        transport.listen();

        TreeUtils treeUtils = new TreeUtils(snmp, new DefaultPDUFactory());
        List<TreeEvent> events = treeUtils.getSubtree(target, new OID(tableOid));
        if (events == null || events.size() == 0) {
            System.out.println("Error: Unable to read table...");
            return result;
        }

        for (TreeEvent event : events) {
            if (event == null) {
                continue;
            }
            if (event.isError()) {
                System.out.println("Error: table OID [" + tableOid + "] " + event.getErrorMessage());
                continue;
            }

            VariableBinding[] varBindings = event.getVariableBindings();
            if (varBindings == null || varBindings.length == 0) {
                continue;
            }
            for (VariableBinding varBinding : varBindings) {
                if (varBinding == null) {
                    continue;
                }
                result.put("#" + varBinding.getOid().toString().replaceAll("\\.","#"), varBinding.getVariable().toString());
            }
        }
        snmp.close();

        return result;
    }
}
