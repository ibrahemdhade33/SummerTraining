package com.example.RemoteCommandsExecutor.Repositories;

import com.example.RemoteCommandsExecutor.Entities.Dir;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface DirRepo extends MongoRepository<Dir,String> {
    @Query("{type : {$eq:?0}}")
    List<Dir> getCommandeType(String Job) ;
    @Query("{hostIp : {$eq:?0}}")
    List<Dir> getByHostIp(String hostIp);
}
