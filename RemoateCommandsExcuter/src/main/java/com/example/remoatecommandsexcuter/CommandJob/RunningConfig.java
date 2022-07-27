package com.example.remoatecommandsexcuter.CommandJob;
import com.example.remoatecommandsexcuter.Command.Show;
import com.example.remoatecommandsexcuter.ParsereStrategy.RunningConfigParser;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
@Getter @Setter
public class RunningConfig extends Show {
    private String type = String.valueOf(Types.running_config);
    public RunningConfig(){
        super();
        CommandParser = new RunningConfigParser();
        CommandParser.result = new ArrayList<>();
    }
}
