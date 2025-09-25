package com.example.exercise02.domain.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "persons")
public class PersonDocument {

    @Id
    private String id;

    private String name;
    private LocalDate birthDate;

    private List<String> hobbies = new ArrayList<>();

    private List<String> events = new ArrayList<>();

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public LocalDate getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }

    public List<String> getHobbies() { return hobbies; }
    public void setHobbies(List<String> hobbies) { this.hobbies = hobbies; }

    public List<String> getEvents() { return events; }
    public void setEvents(List<String> events) { this.events = events; }
}

