package com.example.remoatecommandsexcuter.ParsereStrategy;
import com.example.remoatecommandsexcuter.Components.BootFlashComp;
import com.example.remoatecommandsexcuter.Components.ComponentsParent;
import com.example.remoatecommandsexcuter.Service.Helper.Parser;

import java.util.Collection;


public class BootFlashPartiotionsParser extends Parser {
    @Override
    public Collection<ComponentsParent> parseCommand(String CommandOutput) {

        String[] split= CommandOutput.split("\n") ;

        if (split.length>2){
            for(int i=4 ;i<split.length-2;i++){
                split [i]= split[i].replaceAll("\\s+", " ").trim();
                //System.out.println(split[i]);
                String[] split1 = split[i].split(" ") ;
                for(String j : split1) System.out.print(j+" ");
                System.out.println();
                if (split1.length>1){
                    String datetime = split1[3]+" " + split1[4]+" " + split1[5] +" " + split1[6]+" " + split1[7];
                    result.add(new BootFlashComp(split1[1],Long.parseLong(split1[2]),datetime,split1[8]));
                }
            }

        }
        return result ;
    }
}
