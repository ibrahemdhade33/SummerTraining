package com.example.remoatecommandsexcuter.Entities;
import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

//This class for storing the type of commands that we can execute in this system
//for now we have the dir and show Commands
import javax.persistence.*;
@NoArgsConstructor
@Getter @Setter
@Document("Commands")
public class CommandDocument {
    @Id
    @Indexed(unique = true)
    private String commandName;
    public CommandDocument(String commandName) {
        this.commandName = commandName;
    }
}
