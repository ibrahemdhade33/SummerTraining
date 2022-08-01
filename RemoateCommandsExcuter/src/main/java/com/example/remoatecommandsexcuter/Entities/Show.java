package com.example.remoatecommandsexcuter.Entities;
import com.example.remoatecommandsexcuter.Command.Command;
import com.example.remoatecommandsexcuter.Command.CommandType;
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
