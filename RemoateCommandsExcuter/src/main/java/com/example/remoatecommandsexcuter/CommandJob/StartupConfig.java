package com.example.remoatecommandsexcuter.CommandJob;
import com.example.remoatecommandsexcuter.Command.Show;
import com.example.remoatecommandsexcuter.ParsereStrategy.StartupConfigParser;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter @Setter
public class StartupConfig extends Show {
    private String type = String.valueOf(Types.startup_config);
    public StartupConfig(){
        super();
        CommandParser = new StartupConfigParser();
        CommandParser.result = new ArrayList<>() ;
    }

}
