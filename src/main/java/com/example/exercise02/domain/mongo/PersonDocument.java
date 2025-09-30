package com.example.exercise02.domain.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Document(collection = "persons")
public class PersonDocument {

    @Id
    private String id;

    private UUID globalId;
    private String name;
    private String email;
    private String phone;
    private LocalDate birthDate;

    private List<Long> hobbies = new ArrayList<>();
    private List<UUID> events = new ArrayList<>();
    private List<UUID> friends = new ArrayList<>();

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

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

    public List<Long> getHobbies() { return hobbies; }
    public void setHobbies(List<Long> hobbies) { this.hobbies = hobbies; }

    public List<UUID> getFriends() {
        return friends;
    }

    public void setFriends(List<UUID> friends) {
        this.friends = friends;
    }

    public List<UUID> getEvents() { return events; }
    public void setEvents(List<UUID> events) { this.events = events; }
}
