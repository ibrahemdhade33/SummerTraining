package com.example.remoatecommandsexcuter;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
@EnableMongoRepositories()
@ComponentScan("com.*")
public class RemoateCommandsExcuterApplication {
    public static void main(String[] args) {

        SpringApplication.run(RemoateCommandsExcuterApplication.class, args);

    }

}
