package com.example.remoatecommandsexcuter.ParsereStrategy;
import com.example.remoatecommandsexcuter.Components.ComponentsParent;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.List;

@Service
public abstract class Parser {
    public abstract Collection<ComponentsParent> parseCommand(String CommandOutput);
    public  List<ComponentsParent> result ;
}
