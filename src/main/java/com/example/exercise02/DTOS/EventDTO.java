package com.example.exercise02.DTOS;

import java.time.LocalDate;

public class EventDTO {

    private String name;
    private LocalDate date;
    private String location;
    private String status;

    public EventDTO() {
    }

    public EventDTO(String name, LocalDate date, String location, String status) {
        this.name = name;
        this.date = date;
        this.location = location;
        this.status = status;
    }

    // Getters y setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

