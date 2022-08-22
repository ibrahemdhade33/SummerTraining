package com.example.remoatecommandsexcuter.Service.Helper.ParsereStrategy;
import com.example.remoatecommandsexcuter.Service.Helper.Components.VrfComp;
import com.example.remoatecommandsexcuter.Service.Helper.Components.VrfComp1;
import com.example.remoatecommandsexcuter.Service.Helper.Components.VrfComp2;
import java.util.ArrayList;
import java.util.List;

//paring show vrf command
public class VrfParser extends Parser {
    @Override
    public VrfComp parseCommand(String CommandOutput)  {

        List<VrfComp2>compList2 =null;
        List<VrfComp1> comp1List =null ;
        String []split = CommandOutput.split("\n");
        if (split.length>2){
             comp1List = new ArrayList<>();
            int i ;
            for (i = 2; !split[i].equals(""); i++) {
                System.out.println(split[i]);
                String[] split1 = split[i].split("\\s{2,}");
                if(split1.length>1){ if(split1.length== 4){
                    if(!split1[3].equals("ipv4") && !split1[3].equals("ipv6") && !split1[3].equals("ipv4,ipv6"))
                        comp1List.add(new VrfComp1(split1[1],split1[2],"",split1[3]));
                    else
                        comp1List.add(new VrfComp1(split1[1],split1[2],split1[3],""));
                }
                else if (split1.length==6 || split1.length==5) {
                    comp1List.add(new VrfComp1(split1[1],split1[2],split1[3],split1[4]));
                }}

            }
            i+=2 ;
            compList2 =new ArrayList<>();
            for(;i< split.length;i++){
                String[] split1 = split[i].split("\\s{2,}");
                if(split1.length>1)
                    compList2.add(new VrfComp2(split1[1],Integer.parseInt(split1[2]),split1[3]));
            }
        }

        return new VrfComp(comp1List,compList2);
    }
}
