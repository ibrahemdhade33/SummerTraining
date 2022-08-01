package com.example.remoatecommandsexcuter.ParsereStrategy;

import com.example.remoatecommandsexcuter.Components.ComponentsParent;
import com.example.remoatecommandsexcuter.Components.RunningConfigComp;
import com.example.remoatecommandsexcuter.Service.Helper.Parser;

import java.util.Collection;

public class RunningConfigParser extends Parser {
    @Override
    public Collection<ComponentsParent> parseCommand(String CommandOutput) {
        result.add(new RunningConfigComp(CommandOutput)) ;
        return result ;
    }
}
