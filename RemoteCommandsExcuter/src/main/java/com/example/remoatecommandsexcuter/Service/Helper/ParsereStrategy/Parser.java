package com.example.remoatecommandsexcuter.Service.Helper.ParsereStrategy;
import com.example.remoatecommandsexcuter.Service.Helper.Components.ComponentsParent;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.List;
//the abstracted parser class to implement strategy pattern
@Service
public abstract class Parser {
    @Transient
    public abstract Object parseCommand(String CommandOutput) throws Exception;
    @Transient
    public  List<ComponentsParent> result ;
}
