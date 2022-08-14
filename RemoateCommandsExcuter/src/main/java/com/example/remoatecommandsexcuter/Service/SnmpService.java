package com.example.remoatecommandsexcuter.Service;

import com.example.remoatecommandsexcuter.Entities.Show;
import com.example.remoatecommandsexcuter.Repositories.SnmpRepo;
import com.example.remoatecommandsexcuter.Entities.SnmpInterfaces;
import com.example.remoatecommandsexcuter.Service.Helper.SnmpConnection;
import org.snmp4j.CommunityTarget;
import org.snmp4j.smi.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


@Service
public class SnmpService {
    @Autowired
    SnmpRepo snmpRepo ;
    @Autowired
    SnmpConnection snmpConnection;
    public SnmpInterfaces executeSnmp(String hostIp,String entityOid) {
        try {
            CommunityTarget<Address> target = snmpConnection.creatConnection(hostIp);
            Map<String,String> result =snmpConnection.doWalk(entityOid,target);
            SnmpInterfaces snmpInterfaces = new SnmpInterfaces(hostIp,result, LocalDateTime.now());
            snmpRepo.insert(snmpInterfaces);
            return snmpInterfaces ;
        }
        catch (Exception ignored)
        {

        }
        return null ;

    }

    public List<SnmpInterfaces> getAllSnmp() {
        return snmpRepo.findAll() ;
    }

    public List<SnmpInterfaces> getByHostIp(String hostIp) {
        return snmpRepo.getByHostIp(hostIp);
    }
}
