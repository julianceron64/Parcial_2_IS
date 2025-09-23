package com.example.exercise02.Services;

import com.example.exercise02.domain.neo4j.*;
import com.example.exercise02.Repository.neo4j.*;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FriendshipService {

    private final PersonNeoRepository personNeoRepository;
    private final EventNeoRepository eventNeoRepository;

    public FriendshipService(PersonNeoRepository personNeoRepository, EventNeoRepository eventNeoRepository) {
        this.personNeoRepository = personNeoRepository;
        this.eventNeoRepository = eventNeoRepository;
    }

    public void addFriend(Long personId, Long friendId) {
        PersonNode person = personNeoRepository.findById(personId).orElseThrow();
        PersonNode friend = personNeoRepository.findById(friendId).orElseThrow();

        person.getFriends().add(friend);
        personNeoRepository.save(person);
    }

    public void addPersonToEvent(Long personId, Long eventId) {
        PersonNode person = personNeoRepository.findById(personId).orElseThrow();
        EventNode event = eventNeoRepository.findById(eventId).orElseThrow();

        person.getEvents().add(event);
        personNeoRepository.save(person);
    }

    public void inviteFriendsToEvent(Long personId, Long eventId, List<String> hobbiesOfPerson) {
        PersonNode person = personNeoRepository.findById(personId).orElseThrow();
        EventNode event = eventNeoRepository.findById(eventId).orElseThrow();

        for (PersonNode friend : person.getFriends()) {
            List<String> hobbiesOfFriend = List.of("deporte", "cine");

            boolean shareHobby = hobbiesOfFriend.stream().anyMatch(hobbiesOfPerson::contains);
            if (shareHobby) {
                friend.getEvents().add(event);
                personNeoRepository.save(friend);
            }
        }
    }
}
