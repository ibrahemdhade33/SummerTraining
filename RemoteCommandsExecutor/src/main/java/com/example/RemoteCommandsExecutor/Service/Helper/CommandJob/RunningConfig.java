package com.example.RemoteCommandsExecutor.Service.Helper.CommandJob;
import com.example.RemoteCommandsExecutor.Entities.Show;
import com.example.RemoteCommandsExecutor.Service.Helper.ParsereStrategy.RunningConfigParser;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RunningConfig extends Show {
    private String type = String.valueOf(Types.running_config);
    public RunningConfig(){
        super();
        commandParser = new RunningConfigParser();

    }
}
