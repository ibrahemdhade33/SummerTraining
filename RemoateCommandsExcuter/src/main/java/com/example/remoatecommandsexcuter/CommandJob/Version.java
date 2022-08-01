package com.example.remoatecommandsexcuter.CommandJob;
import com.example.remoatecommandsexcuter.Entities.Show;
import com.example.remoatecommandsexcuter.ParsereStrategy.VersionParser;
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
