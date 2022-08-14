package com.example.remoatecommandsexcuter.Repositories;
import com.example.remoatecommandsexcuter.Entities.SnmpInterfaces;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SnmpRepo extends MongoRepository<SnmpInterfaces,String> {
    @Query("{hostIp : {$eq:?0}}")
    List<SnmpInterfaces> getByHostIp(String hostIp);
}
