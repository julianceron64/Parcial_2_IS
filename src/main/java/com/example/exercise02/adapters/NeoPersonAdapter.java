package com.example.exercise02.adapters;

import com.example.exercise02.Repository.neo4j.EventNeoRepository;
import com.example.exercise02.Repository.neo4j.PersonNeoRepository;
import com.example.exercise02.domain.mysql.Event;
import com.example.exercise02.domain.neo4j.EventNode;
import com.example.exercise02.domain.neo4j.PersonNode;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component("neoPersonAdapter")
public class NeoPersonAdapter implements PersonTarget {

    private final PersonNeoRepository personNeoRepository;
    private final EventNeoRepository eventNeoRepository;

    public NeoPersonAdapter(PersonNeoRepository personNeoRepository, EventNeoRepository eventNeoRepository) {
        this.personNeoRepository = personNeoRepository;
        this.eventNeoRepository = eventNeoRepository;
    }

    @Override
    public void savePerson(String globalId, String name, String email, String phoneNumber, LocalDate birthDate, List<Long> hobbyIds) {
        PersonNode node = new PersonNode();
        node.setGlobalId(globalId);
        node.setName(name);
        personNeoRepository.save(node);
    }

    @Override
    public Optional<String> findGlobalIdByEmailAndPhone(String email, String phone) {
        throw new UnsupportedOperationException("SQL maneja la búsqueda por email+phone");
    }

    @Override
    public void createFriendship(String globalId1, String globalId2) {
        personNeoRepository.createFriendship(globalId1, globalId2);
    }

    @Override
    public void addEvent(String globalId, String name, String location, LocalDate date) {
        EventNode node = new EventNode();
        node.setGlobalId(globalId);
        node.setName(name);
        eventNeoRepository.save(node);
    }

   /*
    public void addPersonToEvent(String personGlobalId, String eventGlobalId) {
        PersonNode person = personNeoRepository.findByGlobalId(personGlobalId);
        EventNode event = eventNeoRepository.findByGlobalId(eventGlobalId);

        if (person != null && event != null) {
            person.getEvents().add(event);
            personNeoRepository.save(person);
        }
    }

    public void addFriend(String personGlobalId, String friendGlobalId) {
        PersonNode person = personNeoRepository.findByGlobalId(personGlobalId);
        PersonNode friend = personNeoRepository.findByGlobalId(friendGlobalId);

        if (person != null && friend != null) {
            person.getFriends().add(friend);
            personNeoRepository.save(person);
        }
    }

    */
}
