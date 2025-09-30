package com.example.exercise02.domain.neo4j;

import org.springframework.data.neo4j.core.schema.*;
import java.util.*;

@Node("Person")
public class PersonNode {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String globalId;

    @Relationship(type = "FRIEND_WITH", direction = Relationship.Direction.OUTGOING)
    private List<PersonNode> friends = new ArrayList<>();

    @Relationship(type = "PARTICIPATES_IN", direction = Relationship.Direction.OUTGOING)
    private List<EventNode> events = new ArrayList<>();


    public PersonNode() {}

    public PersonNode(String name) {
        this.name = name;
    }

    public String getGlobalId() {
        return globalId;
    }

    public void setGlobalId(String globalId) {
        this.globalId = globalId;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<PersonNode> getFriends() { return friends; }
    public void setFriends(List<PersonNode> friends) { this.friends = friends; }

    public List<EventNode> getEvents() { return events; }
    public void setEvents(List<EventNode> events) { this.events = events; }
}
