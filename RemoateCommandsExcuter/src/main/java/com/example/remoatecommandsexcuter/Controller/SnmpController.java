package com.example.remoatecommandsexcuter.Controller;

import com.example.remoatecommandsexcuter.Entities.Show;
import com.example.remoatecommandsexcuter.Entities.SnmpInterfaces;
import com.example.remoatecommandsexcuter.Service.SnmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/Snmp")
public class SnmpController {
    @Autowired
    private SnmpService snmpService ;
    @RequestMapping("/")
    public String snmpWelcome(){
        return "welcome to snmp" ;
    }
    @RequestMapping("/{hostIp}/{entityOid}")
    public SnmpInterfaces excuteSnmp(@PathVariable("hostIp")String hostIp, @PathVariable("entityOid") String entityOid) throws IOException {
        return snmpService.executeSnmp(hostIp,entityOid);
    }
    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public List<SnmpInterfaces>getAllSnmp(){
        return snmpService.getAllSnmp();
    }
    @RequestMapping("/getByHostIp/{hostIp}")
    public List<SnmpInterfaces> getSnmpByHostIp(@PathVariable("hostIp")String hostIp){
        return snmpService.getByHostIp(hostIp);
    }
}
