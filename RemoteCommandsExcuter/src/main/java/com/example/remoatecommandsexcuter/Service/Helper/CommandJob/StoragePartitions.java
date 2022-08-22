package com.example.remoatecommandsexcuter.Service.Helper.CommandJob;
import com.example.remoatecommandsexcuter.Entities.Dir;
import com.example.remoatecommandsexcuter.Service.Helper.ParsereStrategy.StoragePartitionsParser;

public class StoragePartitions extends Dir {
    private final String type = String.valueOf(Types.Question);
     public StoragePartitions(){
         super();
         commandParser = new StoragePartitionsParser();

     }
}
