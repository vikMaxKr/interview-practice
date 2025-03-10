package com.vikash.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication(exclude = {MongoAutoConfiguration.class})
public class MongoApplication {

    public static void main(String[] args) {

        SpringApplication.run(MongoApplication.class,args);
    }
}