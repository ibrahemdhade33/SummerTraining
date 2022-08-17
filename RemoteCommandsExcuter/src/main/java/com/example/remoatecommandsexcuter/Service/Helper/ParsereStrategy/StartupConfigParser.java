package com.example.remoatecommandsexcuter.Service.Helper.ParsereStrategy;
import com.example.remoatecommandsexcuter.Service.Helper.Components.ComponentsParent;
import com.example.remoatecommandsexcuter.Service.Helper.Components.StartUpConfigComp;

import java.util.Collection;


public class StartupConfigParser extends Parser {
    @Override
    public Collection<ComponentsParent> parseCommand(String CommandOutput) {
            result.add(new StartUpConfigComp(CommandOutput));
        return result ;
    }
}
