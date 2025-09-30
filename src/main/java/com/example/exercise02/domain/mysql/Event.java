package com.example.exercise02.domain.mysql;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "global_id", nullable = false, unique = true)
    private String globalId;

    private String name;

    private LocalDate date;

    private String location;

    @Enumerated(EnumType.STRING)
    private EventStatus status;

    @ManyToMany(mappedBy = "events")
    private List<Person> participants = new ArrayList<>();

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public EventStatus getStatus() { return status; }
    public void setStatus(EventStatus status) { this.status = status; }

    public void setGlobalId(String globalId) {
        this.globalId = globalId;
    }

    public String getGlobalId() {
        return globalId;
    }

    public List<Person> getParticipants() { return participants; }
    public void setParticipants(List<Person> participants) { this.participants = participants; }
}
