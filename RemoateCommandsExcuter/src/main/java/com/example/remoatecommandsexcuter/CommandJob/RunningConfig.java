package com.example.remoatecommandsexcuter.CommandJob;
import com.example.remoatecommandsexcuter.Entities.Show;
import com.example.remoatecommandsexcuter.ParsereStrategy.RunningConfigParser;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
@Getter @Setter
public class RunningConfig extends Show {
    private String type = String.valueOf(Types.running_config);
    public RunningConfig(){
        super();
        commandParser = new RunningConfigParser();
        commandParser.result = new ArrayList<>();
    }
}
