package com.example.RemoteCommandsExecutor.Service.Helper.ParsereStrategy;
import com.example.RemoteCommandsExecutor.Service.Helper.Components.StoragePartitionsComp;
import java.util.HashMap;
import java.util.Map;

//
public class StoragePartitionsParser extends Parser {
    @Override
    public StoragePartitionsComp parseCommand(String commandOutput) {
        Map<String,String>parsedString = new HashMap<>();
        String []split = commandOutput.split("\n") ;
        for(int i=1;i< split.length-3;i++){

          split[i] =  split[i].trim().replaceAll("\\s+", " ");
            String [] split1 = split[i].split(" ",2);
            parsedString.put(split1[0],split1[1]) ;

        }

        return new StoragePartitionsComp(parsedString) ;
    }
}
