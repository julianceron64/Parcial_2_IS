package com.example.exercise02.Repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.exercise02.domain.mongo.Hobby;

import java.util.List;
import java.util.Optional;

public interface HobbyRepository extends MongoRepository<Hobby, String> {
    Optional<Hobby> findByName(String name);
    @Override
    List<Hobby> findAllById(Iterable<String> ids);
}
