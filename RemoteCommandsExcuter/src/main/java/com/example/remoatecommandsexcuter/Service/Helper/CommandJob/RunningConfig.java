package com.example.remoatecommandsexcuter.Service.Helper.CommandJob;
import com.example.remoatecommandsexcuter.Entities.Show;
import com.example.remoatecommandsexcuter.Service.Helper.ParsereStrategy.RunningConfigParser;
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
