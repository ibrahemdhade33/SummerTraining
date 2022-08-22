package com.example.remoatecommandsexcuter.Service.Helper.ParsereStrategy;

import com.example.remoatecommandsexcuter.Service.Helper.Components.ComponentsParent;
import com.example.remoatecommandsexcuter.Service.Helper.Components.RunningConfigComp;

import java.util.Collection;
//parsing the show running-config command
public class RunningConfigParser extends Parser {
    @Override
    public Object parseCommand(String CommandOutput) throws Exception {
        if(CommandOutput.equals(""))
            throw new Exception("Error") ;
        else
            return CommandOutput ;
    }
}
