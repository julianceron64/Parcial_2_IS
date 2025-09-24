package com.example.exercise02.Services;

import com.example.exercise02.Repository.mysql.EventRepository;
import com.example.exercise02.domain.mysql.Event;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    public Event save(Event event) {
        return eventRepository.save(event);
    }
}
