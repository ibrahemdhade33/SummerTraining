package com.example.RemoteCommandsExecutor.Repositories;
import com.example.RemoteCommandsExecutor.Entities.Show;
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
