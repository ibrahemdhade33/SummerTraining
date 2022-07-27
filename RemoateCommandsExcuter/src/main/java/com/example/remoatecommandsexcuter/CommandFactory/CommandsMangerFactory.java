package com.example.remoatecommandsexcuter.CommandFactory;
import com.example.remoatecommandsexcuter.Command.Command;
import com.example.remoatecommandsexcuter.CommandJob.*;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
@NoArgsConstructor
@Service
public class CommandsMangerFactory {

    public Command getCommandObject(String type){
        Command command =null ;
        if(type.equals(String.valueOf(Types.ip_interface_brief)))
            return new IpInterfaceBrief() ;
        else if(type.equals(String.valueOf(Types.bootflash)))
            return new BootFlashPartitions() ;
        else if(type.equals(String.valueOf(Types.vrf)))
            return new VRF() ;
        else if(type.equals(String.valueOf(Types.Question)))
            return new StoragePartitions();
        else if(type.equals(String.valueOf(Types.running_config)))
            return new RunningConfig() ;
        else if(type.equals(String.valueOf(Types.startup_config)))
            return new StartupConfig() ;
        else if(type.equals(String.valueOf(Types.version)))
            return new Version() ;
        return null ;
    }

}
