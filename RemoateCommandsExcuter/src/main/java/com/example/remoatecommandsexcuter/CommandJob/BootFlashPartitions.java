package com.example.remoatecommandsexcuter.CommandJob;
import com.example.remoatecommandsexcuter.Entities.Dir;
import com.example.remoatecommandsexcuter.ParsereStrategy.BootFlashPartiotionsParser;
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
