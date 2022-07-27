package com.example.remoatecommandsexcuter.Command;
import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.persistence.*;
@NoArgsConstructor
@Getter @Setter
@Document("Commands")
public class CommandDocument {
    @Id
    @Indexed(unique = true)
    private String CommandName;
    public CommandDocument(String commandName) {
        CommandName = commandName;
    }
}
