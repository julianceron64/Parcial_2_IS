package com.example.exercise02.adapters;

import com.example.exercise02.Repository.neo4j.EventNeoRepository;
import com.example.exercise02.Repository.neo4j.PersonNeoRepository;
import com.example.exercise02.domain.neo4j.EventNode;
import com.example.exercise02.domain.neo4j.PersonNode;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component("neoPersonAdapter")
public class NeoPersonAdapter implements PersonTarget {

    private final PersonNeoRepository personNeoRepository;
    private final EventNeoRepository eventNeoRepository;

    public NeoPersonAdapter(PersonNeoRepository personNeoRepository, EventNeoRepository eventNeoRepository) {
        this.personNeoRepository = personNeoRepository;
        this.eventNeoRepository = eventNeoRepository;
    }

    @Override
    public void savePerson(String name, LocalDate birthDate, List<String> hobbyIds) {
        PersonNode node = new PersonNode(name);
        personNeoRepository.save(node);
    }




}
