package com.example.remoatecommandsexcuter.Repositories;

import com.example.remoatecommandsexcuter.Command.Dir;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DirRepo extends MongoRepository<Dir,String> {
}
