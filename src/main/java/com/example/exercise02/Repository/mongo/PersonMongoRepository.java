package com.example.exercise02.Repository.mongo;

import com.example.exercise02.domain.mongo.PersonDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PersonMongoRepository extends MongoRepository<PersonDocument, String> {
    Optional<PersonDocument> findByEmailAndPhone(String email, String phone);
    Optional<PersonDocument> findByGlobalId(UUID globalId);
    PersonDocument findByName(String name);
}

