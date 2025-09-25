package com.example.exercise02.DTOS;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class PersonDTO {
    private UUID id;          // ID global
    private String name;
    private LocalDate birthDate;
    private List<String> hobbyIds;
    private List<String> eventIds;


    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public LocalDate getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }

    public List<String> getHobbyIds() { return hobbyIds; }
    public void setHobbyIds(List<String> hobbyIds) { this.hobbyIds = hobbyIds; }

    public List<String> getEventIds() { return eventIds; }
    public void setEventIds(List<String> eventIds) { this.eventIds = eventIds; }
}
