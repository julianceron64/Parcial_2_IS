package com.example.exercise02.domain.neo4j;

import org.springframework.data.neo4j.core.schema.*;
import java.util.*;

@Node("Event")
public class EventNode {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

   
    @Relationship(type = "PARTICIPATES_IN", direction = Relationship.Direction.INCOMING)
    private List<PersonNode> participants = new ArrayList<>();

  
    public EventNode() {}

    public EventNode(String name) {
        this.name = name;
    }

   
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<PersonNode> getParticipants() { return participants; }
    public void setParticipants(List<PersonNode> participants) { this.participants = participants; }
}
