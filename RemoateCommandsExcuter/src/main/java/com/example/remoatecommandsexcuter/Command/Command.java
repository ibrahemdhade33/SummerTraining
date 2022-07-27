package com.example.remoatecommandsexcuter.Command;

import com.example.remoatecommandsexcuter.Components.ComponentsParent;
import com.example.remoatecommandsexcuter.ParsereStrategy.Parser;

import org.springframework.data.annotation.Transient;
import java.time.LocalDateTime;

import java.util.Collection;
import java.util.List;



public class Command {
    public transient Parser CommandParser;
    private LocalDateTime localDateTime;
    public List<ComponentsParent> info;
    public Command(){
        this.localDateTime = LocalDateTime.now();
    }
    public Collection<ComponentsParent> getParsedCommand(String CommandOutput){
        return CommandParser.parseCommand(CommandOutput);
    }
    public List<ComponentsParent> getInfo() {
        return info;
    }
    public void setInfo(List<ComponentsParent> info) {
        this.info = info;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
