package com.example.remoatecommandsexcuter.Repositories;



import com.example.remoatecommandsexcuter.Service.Helper.Command.CommandDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandRepo extends MongoRepository<CommandDocument,String> {

}