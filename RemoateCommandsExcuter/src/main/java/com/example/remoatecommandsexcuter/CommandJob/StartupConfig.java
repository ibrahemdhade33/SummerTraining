package com.example.remoatecommandsexcuter.CommandJob;
import com.example.remoatecommandsexcuter.Entities.Show;
import com.example.remoatecommandsexcuter.ParsereStrategy.StartupConfigParser;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter @Setter
public class StartupConfig extends Show {
    private String type = String.valueOf(Types.startup_config);
    public StartupConfig(){
        super();
        commandParser = new StartupConfigParser();
        commandParser.result = new ArrayList<>() ;
    }

}
