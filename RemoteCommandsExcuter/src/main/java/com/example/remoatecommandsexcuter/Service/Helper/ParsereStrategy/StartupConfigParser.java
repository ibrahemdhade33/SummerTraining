package com.example.remoatecommandsexcuter.Service.Helper.ParsereStrategy;
import com.example.remoatecommandsexcuter.Service.Helper.Components.ComponentsParent;
import com.example.remoatecommandsexcuter.Service.Helper.Components.StartUpConfigComp;

import java.util.Collection;

//parsing the startup-config command
public class StartupConfigParser extends Parser {
    @Override
    public String parseCommand(String CommandOutput) throws Exception {
        if(CommandOutput.equals(""))
            throw new Exception("Error") ;
        else
            return CommandOutput ;

    }
}
