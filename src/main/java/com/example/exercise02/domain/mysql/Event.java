package com.example.exercise02.domain.mysql;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Date date;
    private String location;

    @Enumerated(EnumType.STRING) 
    private EventStatus status;

    @ManyToMany(mappedBy = "events")
    private List<Person> participants = new ArrayList<>();


    // Getters y setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public EventStatus getStatus() { return status; }
    public void setStatus(EventStatus status) { this.status = status; }

    public List<Person> getParticipants() { return participants; }
    public void setParticipants(List<Person> participants) { this.participants = participants; }
}
