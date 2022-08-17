package com.example.remoatecommandsexcuter.Service.Helper.ParsereStrategy;

import com.example.remoatecommandsexcuter.Service.Helper.Components.ComponentsParent;
import com.example.remoatecommandsexcuter.Service.Helper.Components.VersionComp;
import com.example.remoatecommandsexcuter.Service.Helper.Parser;

import java.util.Collection;

public class VersionParser extends Parser {
    @Override
    public Collection<ComponentsParent> parseCommand(String CommandOutput) {
        String[]split = CommandOutput.split("\n") ;
        if (split.length>2){
            String softwareFamily,softwareType,version,systemImageFile ;
            String []split1 =  split[2].split(" ") ;
            version = split1[split1.length-1];
            softwareFamily=split1[1];
            softwareType = split1[2];
            systemImageFile =split[25];

            result.add(new VersionComp(version,softwareType,softwareFamily,systemImageFile,""));
        }
        return result;
    }
}
