package com.example.exercise02.Repository.mongo;

import com.example.exercise02.domain.mongo.PersonDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonMongoRepository extends MongoRepository<PersonDocument, String> {

    PersonDocument findByName(String name);
}

