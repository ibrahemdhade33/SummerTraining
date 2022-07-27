package com.example.remoatecommandsexcuter.Command;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("Dir")
public class Dir extends Command {
    private String Name = String.valueOf(CommandType.Dir);
    public Dir(){
        super();
    }
}
