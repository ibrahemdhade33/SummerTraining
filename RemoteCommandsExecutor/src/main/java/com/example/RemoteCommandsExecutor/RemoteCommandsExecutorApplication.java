package com.example.RemoteCommandsExecutor;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
@EnableMongoRepositories()
@ComponentScan("com.*")
public class RemoteCommandsExecutorApplication {
    public static void main(String[] args) {
        SpringApplication.run(RemoteCommandsExecutorApplication.class, args);

    }

}
