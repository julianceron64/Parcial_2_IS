package com.example.exercise02.Services;

import com.example.exercise02.domain.mysql.Person;
import com.example.exercise02.domain.mongo.Hobby;
import com.example.exercise02.domain.neo4j.PersonNode;
import com.example.exercise02.Repository.mysql.PersonRepository;
import com.example.exercise02.Repository.mongo.HobbyRepository;
import com.example.exercise02.Repository.neo4j.PersonNeoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final HobbyRepository hobbyRepository;
    private final PersonNeoRepository personNeoRepository;

    public PersonService(PersonRepository personRepository,
                         HobbyRepository hobbyRepository,
                         PersonNeoRepository personNeoRepository) {
        this.personRepository = personRepository;
        this.hobbyRepository = hobbyRepository;
        this.personNeoRepository = personNeoRepository;
    }

    public Person createPerson(String name, LocalDate birthDate, List<String> hobbyNames) {
        PersonNode node = new PersonNode(name);
        node = personNeoRepository.save(node);

        List<String> hobbyIds = hobbyNames.stream()
                .map(hobbyName -> hobbyRepository.findByName(hobbyName)
                        .orElseGet(() -> hobbyRepository.save(
                                new Hobby(hobbyName, "Descripción pendiente")
                        ))
                        .getId()
                )
                .collect(Collectors.toList());

        // Guardar persona en MySQL
        Person person = new Person();
        person.setName(name);
        person.setBirthDate(birthDate);
        person.setHobbyIds(hobbyIds);
        person.setNeo4jNodeId(node.getId());

        return personRepository.save(person);
    }

    public List<Hobby> getHobbies(Person person) {
        return hobbyRepository.findAllById(person.getHobbyIds());
    }

    public List<Person> findPersonsByHobby(String hobbyName) {
        return hobbyRepository.findByName(hobbyName)
                .map(hobby -> personRepository.findByHobbyIdsContains(hobby.getId()))
                .orElse(List.of());
    }


    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person save(Person person) {
        return personRepository.save(person);
    }


    public List<PersonNode> getFriends(Person person) {
        if (person.getNeo4jNodeId() == null) return List.of();
        return personNeoRepository.findById(person.getNeo4jNodeId())
                .map(PersonNode::getFriends)
                .orElse(List.of());
    }

    public Optional<PersonNode> getPersonNodeByName(String name) {
        return personNeoRepository.findByName(name);
    }

    public List<PersonNode> getFriendsByName(String name) {
        return personNeoRepository.findFriendsByName(name);
    }

    public List<PersonNode> getParticipantsByEvent(String eventName) {
        return personNeoRepository.findParticipantsByEvent(eventName);
    }

    public Optional<PersonNode> getPersonWithFriendsAndEvents(String name) {
        return personNeoRepository.findPersonWithFriendsAndEvents(name);
    }
}
