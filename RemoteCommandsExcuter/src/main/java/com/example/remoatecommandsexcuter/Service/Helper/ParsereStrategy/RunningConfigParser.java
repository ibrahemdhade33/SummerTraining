package com.example.remoatecommandsexcuter.Service.Helper.ParsereStrategy;

import com.example.remoatecommandsexcuter.Service.Helper.Components.ComponentsParent;
import com.example.remoatecommandsexcuter.Service.Helper.Components.RunningConfigComp;

import java.util.Collection;
//parsing the show running-config command
public class RunningConfigParser extends Parser {
    @Override
    public Collection<ComponentsParent> parseCommand(String CommandOutput) {
        result.add(new RunningConfigComp(CommandOutput)) ;
        return result ;
    }
}
