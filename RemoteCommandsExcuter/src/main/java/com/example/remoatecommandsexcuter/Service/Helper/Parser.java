package com.example.remoatecommandsexcuter.Service.Helper;
import com.example.remoatecommandsexcuter.Service.Helper.Components.ComponentsParent;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.List;

@Service
public abstract class Parser {
    @Transient
    public abstract Collection<ComponentsParent> parseCommand(String CommandOutput);
    @Transient
    public  List<ComponentsParent> result ;
}
