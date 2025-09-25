package com.example.exercise02.domain.mysql;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @ElementCollection
    @CollectionTable(
            name = "person_hobbies",
            joinColumns = @JoinColumn(name = "person_id")
    )
    @Column(name = "hobby_id")
    private List<String> hobbyIds = new ArrayList<>();

    private Long neo4jNodeId;

    @ManyToMany
    @JoinTable(
            name = "person_event",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id")
    )
    private List<Event> events = new ArrayList<>();

    // --- Getters y setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public LocalDate getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }

    public List<String> getHobbyIds() { return hobbyIds; }
    public void setHobbyIds(List<String> hobbyIds) { this.hobbyIds = hobbyIds; }

    public Long getNeo4jNodeId() { return neo4jNodeId; }
    public void setNeo4jNodeId(Long neo4jNodeId) { this.neo4jNodeId = neo4jNodeId; }

    public List<Event> getEvents() { return events; }
    public void setEvents(List<Event> events) { this.events = events; }
}
