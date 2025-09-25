package com.example.exercise02.Repository.neo4j;

import com.example.exercise02.domain.neo4j.PersonNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonNeoRepository extends Neo4jRepository<PersonNode, Long> {

   PersonNode findByName(String name);

    @Query("MATCH (p:Person)-[:FRIEND_OF]->(f:Person) WHERE p.name = $name RETURN f")
    List<PersonNode> findFriendsByName(String name);

    @Query("MATCH (p:Person)-[:PARTICIPATES_IN]->(e:Event) WHERE e.name = $eventName RETURN p")
    List<PersonNode> findParticipantsByEvent(String eventName);

    @Query("MATCH (p:Person {name: $name}) " +
            "OPTIONAL MATCH (p)-[:FRIEND_OF]->(f:Person) " +
            "OPTIONAL MATCH (p)-[:PARTICIPATES_IN]->(e:Event) " +
            "RETURN p, collect(f), collect(e)")
    Optional<PersonNode> findPersonWithFriendsAndEvents(String name);
}
