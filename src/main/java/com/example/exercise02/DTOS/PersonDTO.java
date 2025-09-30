package com.example.exercise02.DTOS;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class PersonDTO {
    private UUID globalId;
    private String name;
    private String email;
    private String phone;
    private LocalDate birthDate;
    private List<Long> hobbyIds;
    private List<Long> eventIds;

    public UUID getGlobalId() { return globalId; }
    public void setGlobalId(UUID globalId) { this.globalId = globalId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public LocalDate getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }

    public List<Long> getHobbyIds() { return hobbyIds; }
    public void setHobbyIds(List<Long> hobbyIds) { this.hobbyIds = hobbyIds; }

    public List<Long> getEventIds() { return eventIds; }
    public void setEventIds(List<Long> eventIds) { this.eventIds = eventIds; }
}
