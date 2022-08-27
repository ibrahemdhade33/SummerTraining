package com.example.RemoteCommandsExecutor.Service.Helper.CommandJob;
import com.example.RemoteCommandsExecutor.Entities.Show;
import com.example.RemoteCommandsExecutor.Service.Helper.ParsereStrategy.StartupConfigParser;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class StartupConfig extends Show {
    private String type = String.valueOf(Types.startup_config);
    public StartupConfig(){
        super();
        commandParser = new StartupConfigParser();

    }

}
