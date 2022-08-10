package com.example.remoatecommandsexcuter.Entities;

import com.example.remoatecommandsexcuter.Command.Command;
import com.example.remoatecommandsexcuter.Command.CommandType;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Dir")
@ToString
public class Dir extends Command {
    private String  name = String.valueOf(CommandType.Dir);
    public Dir(){
        super();
    }
}
