package com.example.remoatecommandsexcuter.Service.Helper;
import com.example.remoatecommandsexcuter.Command.Command;
import com.example.remoatecommandsexcuter.CommandJob.*;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
@NoArgsConstructor
@Service
public class CommandsMangerFactory {

    public Command getCommandObject(String type){

        if(type.equals("ip interface brief"))
            return new IpInterfaceBrief() ;
        else if(type.equals("bootflash:"))
            return new BootFlashPartitions() ;
        else if(type.equals("vrf"))
            return new VRF() ;
        else if(type.equals(String.valueOf(Types.Question)))
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
