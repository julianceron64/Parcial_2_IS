package com.example.exercise02.Repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.exercise02.domain.mongo.Hobby;

public interface HobbyRepository extends MongoRepository<Hobby, String> {
   
}
