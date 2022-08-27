package com.example.RemoteCommandsExecutor.Repositories;
import com.example.RemoteCommandsExecutor.Entities.CommandDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandRepo extends MongoRepository<CommandDocument,String> {
}