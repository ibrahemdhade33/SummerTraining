package com.example.remoatecommandsexcuter.CommandJob;
import com.example.remoatecommandsexcuter.Entities.Show;
import com.example.remoatecommandsexcuter.ParsereStrategy.IpInternetBreifParser;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;


@Getter @Setter
public class IpInterfaceBrief extends Show {
    private String type = String.valueOf(Types.ip_interface_brief);
    public IpInterfaceBrief() {
        super();
        commandParser = new IpInternetBreifParser();
        commandParser.result = new ArrayList<>() ;
    }


}
