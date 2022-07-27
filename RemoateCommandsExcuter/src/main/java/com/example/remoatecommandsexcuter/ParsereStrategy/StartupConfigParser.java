package com.example.remoatecommandsexcuter.ParsereStrategy;
import com.example.remoatecommandsexcuter.Components.ComponentsParent;
import com.example.remoatecommandsexcuter.Components.StartUpConfigComp;

import java.util.Collection;


public class StartupConfigParser extends Parser{
    @Override
    public Collection<ComponentsParent> parseCommand(String CommandOutput) {
            result.add(new StartUpConfigComp(CommandOutput));
        return result ;
    }
}
