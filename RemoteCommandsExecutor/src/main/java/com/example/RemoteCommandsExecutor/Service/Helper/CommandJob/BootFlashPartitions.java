package com.example.RemoteCommandsExecutor.Service.Helper.CommandJob;
import com.example.RemoteCommandsExecutor.Entities.Dir;
import com.example.RemoteCommandsExecutor.Service.Helper.ParsereStrategy.BootFlashPartiotionsParser;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
@Getter @Setter
public class BootFlashPartitions extends Dir {
    private String type = String.valueOf(Types.bootflash);
    public BootFlashPartitions(){
        super();
        commandParser = new BootFlashPartiotionsParser();
        commandParser.result = new ArrayList<>();
    }
}
