package com.example.RemoteCommandsExecutor.Service;

import com.example.RemoteCommandsExecutor.Repositories.SnmpRepo;
import com.example.RemoteCommandsExecutor.Entities.SnmpInterfaces;
import com.example.RemoteCommandsExecutor.Service.Helper.Connection.SnmpConnection;
import org.snmp4j.CommunityTarget;
import org.snmp4j.smi.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

//business logic for snmp command
@Service
public class SnmpService {
    @Autowired
    SnmpRepo snmpRepo ;
    @Autowired
    SnmpConnection snmpConnection;
    public Object executeSnmp(String hostIp,String entityOid) {
        try {
            CommunityTarget<Address> target = snmpConnection.creatConnection(hostIp);
            Map<String,String> result =snmpConnection.doWalk(entityOid,target);
            SnmpInterfaces snmpInterfaces = new SnmpInterfaces(hostIp,result, LocalDateTime.now());
            snmpRepo.insert(snmpInterfaces);
            return snmpInterfaces ;
        }
        catch (Exception ignored)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("there is an error with info you entered") ;
        }

    }

    public List<SnmpInterfaces> getAllSnmp() {
        return snmpRepo.findAll() ;
    }

    public List<SnmpInterfaces> getByHostIp(String hostIp) {
        return snmpRepo.getByHostIp(hostIp);
    }
}
