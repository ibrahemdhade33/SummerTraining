package com.example.remoatecommandsexcuter.CommandJob;
import com.example.remoatecommandsexcuter.Entities.Show;
import com.example.remoatecommandsexcuter.ParsereStrategy.VrfParser;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
@Getter @Setter
public class VRF extends Show {
    private String type = String.valueOf(Types.vrf);
    public VRF(){
        super();
        commandParser = new VrfParser();
        commandParser.result = new ArrayList<>();
    }
}
