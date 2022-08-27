package com.example.RemoteCommandsExecutor.Service.Helper.CommandJob;
import com.example.RemoteCommandsExecutor.Entities.Dir;
import com.example.RemoteCommandsExecutor.Service.Helper.ParsereStrategy.StoragePartitionsParser;

public class StoragePartitions extends Dir {
    private final String type = String.valueOf(Types.Question);
     public StoragePartitions(){
         super();
         commandParser = new StoragePartitionsParser();

     }
}
