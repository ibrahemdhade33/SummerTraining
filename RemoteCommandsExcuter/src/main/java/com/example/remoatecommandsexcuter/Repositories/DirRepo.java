package com.example.remoatecommandsexcuter.Repositories;

import com.example.remoatecommandsexcuter.Entities.Dir;
import com.example.remoatecommandsexcuter.Entities.Show;
import com.example.remoatecommandsexcuter.Entities.SnmpInterfaces;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface DirRepo extends MongoRepository<Dir,String> {
    @Query("{type : {$eq:?0}}")
    List<Dir> getCommandeType(String Job) ;
    @Query("{hostIp : {$eq:?0}}")
    List<Dir> getByHostIp(String hostIp);
}
