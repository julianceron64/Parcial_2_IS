package com.example.exercise02.domain.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "events")
public class EventDocument {

    @Id
    private String id;

    private String globalId;

    private String name;

    private LocalDate date;

    private String location;

    private String status;

    private List<String> participants = new ArrayList<>();
    public EventDocument() {}

    public EventDocument(String globalId, String name, LocalDate date, String location, String status) {
        this.globalId = globalId;
        this.name = name;
        this.date = date;
        this.location = location;
        this.status = status;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getGlobalId() { return globalId; }
    public void setGlobalId(String globalId) { this.globalId = globalId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public List<String> getParticipants() { return participants; }
    public void setParticipants(List<String> participants) { this.participants = participants; }
}

