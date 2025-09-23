package com.example.exercise02.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "com.example.exercise02.domain.mysql")
@EnableJpaRepositories(basePackages = "com.example.exercise02.Repository.mysql")
public class MySQLConfig {
}
