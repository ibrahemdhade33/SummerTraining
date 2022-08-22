package com.example.remoatecommandsexcuter.Repositories;
import com.example.remoatecommandsexcuter.Entities.Show;
import com.example.remoatecommandsexcuter.Entities.SnmpInterfaces;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ShowRepo extends MongoRepository<Show,String>{
    @Query("{type : {$eq:?0}}")
    List<Show> getCommandeType(String Job);
    @Query("{hostIp : {$eq:?0}}")
    List<Show> getByHostIp(String hostIp);

}
