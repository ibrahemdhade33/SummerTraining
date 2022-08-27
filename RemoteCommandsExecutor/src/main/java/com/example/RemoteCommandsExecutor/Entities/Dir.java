package com.example.RemoteCommandsExecutor.Entities;

import com.example.RemoteCommandsExecutor.Service.Helper.Command.Command;
import com.example.RemoteCommandsExecutor.Service.Helper.Command.CommandType;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Dir")
@ToString
public class Dir extends Command {
    private final String  name = String.valueOf(CommandType.Dir);
    public Dir(){
        super();
    }
}
