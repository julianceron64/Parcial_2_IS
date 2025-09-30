package com.example.exercise02.Repository.neo4j;

import com.example.exercise02.domain.neo4j.EventNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface EventNeoRepository extends Neo4jRepository<EventNode, Long> {
}
