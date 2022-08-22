package com.example.remoatecommandsexcuter.Service.Helper.Command;
import com.example.remoatecommandsexcuter.Service.Helper.Command.Command;

import com.example.remoatecommandsexcuter.Service.Helper.CommandJob.*;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
@NoArgsConstructor
@Service
public class CommandsMangerFactory {

    public Command getCommandObject(String type){
        type = type.trim() ;
        if(type.equals("ip interface brief"))
            return new IpInterfaceBrief() ;
        else if(type.equals("bootflash:"))
            return new BootFlashPartitions() ;
        else if(type.equals("vrf"))
            return new VRF() ;
        else if(type.equals("?"))
            return new StoragePartitions();
        else if(type.equals("running-config"))
            return new RunningConfig() ;
        else if(type.equals("startup-config"))
            return new StartupConfig() ;
        else if(type.equals("version"))
            return new Version() ;
        return null ;
    }

}
