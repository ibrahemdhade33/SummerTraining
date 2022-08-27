package com.example.RemoteCommandsExecutor.Service.Helper.CommandJob;
import com.example.RemoteCommandsExecutor.Entities.Show;
import com.example.RemoteCommandsExecutor.Service.Helper.ParsereStrategy.VrfParser;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VRF extends Show {
    private String type = String.valueOf(Types.vrf);
    public VRF(){
        super();
        commandParser = new VrfParser();

    }
}
