package com.example.exercise02.Repository.mongo;

import com.example.exercise02.domain.mongo.EventDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventMongoRepository extends MongoRepository<EventDocument, String> {
}
