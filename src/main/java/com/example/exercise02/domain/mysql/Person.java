package com.example.exercise02.domain.mysql;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Relación con hobbies (MongoDB: almacenamos solo los IDs)
    @ElementCollection
    private List<String> hobbyIds;

    // Relación con Neo4j: nodo asociado (ID del nodo en Neo4j)
    private Long neo4jNodeId;

    
    public Person() {}

    public Person(String name) {
        this.name = name;
    }

     @ManyToMany
    @JoinTable(
        name = "person_event",
        joinColumns = @JoinColumn(name = "person_id"),
        inverseJoinColumns = @JoinColumn(name = "event_id")
    )
    private List<Event> events = new ArrayList<>();

 
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<String> getHobbyIds() { return hobbyIds; }
    public void setHobbyIds(List<String> hobbyIds) { this.hobbyIds = hobbyIds; }

    public Long getNeo4jNodeId() { return neo4jNodeId; }
    public void setNeo4jNodeId(Long neo4jNodeId) { this.neo4jNodeId = neo4jNodeId; }
}
