package com.example.RemoteCommandsExecutor.Service.Helper.CommandJob;
import com.example.RemoteCommandsExecutor.Entities.Show;
import com.example.RemoteCommandsExecutor.Service.Helper.ParsereStrategy.VersionParser;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
@Getter @Setter
public class Version extends Show {
    private String type = String.valueOf(Types.version);
    public Version(){
        super();
        commandParser = new VersionParser();
        commandParser.result = new ArrayList<>() ;
    }
}
