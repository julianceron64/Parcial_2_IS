package com.example.exercise02.Repository.neo4j;

import com.example.exercise02.domain.neo4j.PersonNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface PersonNeoRepository extends Neo4jRepository<PersonNode, Long> {
}
