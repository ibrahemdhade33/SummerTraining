package com.example.RemoteCommandsExecutor.Entities;
import com.example.RemoteCommandsExecutor.Service.Helper.Command.Command;
import com.example.RemoteCommandsExecutor.Service.Helper.Command.CommandType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.ArrayList;

@Document("Show")
@Getter @Setter
public class Show extends Command {
    private String name = String.valueOf(CommandType.Show);
    public Show(){
        super();
        info = new ArrayList<>();
    }
}
