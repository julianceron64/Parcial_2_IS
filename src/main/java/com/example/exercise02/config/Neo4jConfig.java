package com.example.exercise02.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@Configuration
@EnableNeo4jRepositories(basePackages = "com.example.exercise02.Repository.neo4j")
public class Neo4jConfig {
}
