package com.example.exercise02.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.example.exercise02.Repository.mongo")
public class MongoConfig {
}
