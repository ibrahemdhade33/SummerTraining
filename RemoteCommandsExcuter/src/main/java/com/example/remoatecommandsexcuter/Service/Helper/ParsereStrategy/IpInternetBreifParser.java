package com.example.remoatecommandsexcuter.Service.Helper.ParsereStrategy;
import com.example.remoatecommandsexcuter.Service.Helper.Components.ComponentsParent;
import com.example.remoatecommandsexcuter.Service.Helper.Components.IpinterfaceBriefComp;

import java.util.Collection;



public class IpInternetBreifParser extends Parser {

    @Override
    public Collection<ComponentsParent> parseCommand(String CommandOutput) {

            String []split = CommandOutput.split("\n");
            if (split.length>2){
                for (int i = 2; i < split.length; i++) {
                    split[i] = split[i].replaceAll("\\s+", " ");

                    String[] split1 = split[i].split(" ") ;
                    if (split1.length > 1)
                        result.add(new IpinterfaceBriefComp(split1[0],split1[1],split1[2].equals("YES"),split1[3],split1[4],split1[5]));
                }
            }
        return result ;
    }
}
