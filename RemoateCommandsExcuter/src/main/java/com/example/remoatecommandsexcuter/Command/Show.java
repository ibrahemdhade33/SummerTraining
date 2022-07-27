package com.example.remoatecommandsexcuter.Command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.ArrayList;

@Document("Show")
@Getter @Setter
public class Show extends Command{
    private String CommandName = String.valueOf(CommandType.Show);
    public Show(){
        super();
        info = new ArrayList<>();
    }
}
