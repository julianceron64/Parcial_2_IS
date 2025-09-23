package com.example.exercise02.Services;

import com.example.exercise02.domain.mysql.Person;
import com.example.exercise02.domain.mongo.Hobby;
import com.example.exercise02.domain.neo4j.PersonNode;
import com.example.exercise02.Repository.mysql.PersonRepository;
import com.example.exercise02.Repository.mongo.HobbyRepository;
import com.example.exercise02.Repository.neo4j.PersonNeoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    // Crear persona en MySQL + Neo4j
    public Person createPerson(String name) {
        // 1. Guardar en Neo4j
        PersonNode node = new PersonNode(name);
        node = personNeoRepository.save(node);

        // 2. Guardar en MySQL con referencia a Neo4j
        Person person = new Person(name);
        person.setNeo4jNodeId(node.getId());
        return personRepository.save(person);
    }

    // Obtener hobbies de una persona desde Mongo
    public List<Hobby> getHobbies(Person person) {
        return hobbyRepository.findAllById(person.getHobbyIds());
    }

    // Obtener amigos de una persona desde Neo4j
    public List<PersonNode> getFriends(Person person) {
        if (person.getNeo4jNodeId() == null) return List.of();
        return personNeoRepository.findById(person.getNeo4jNodeId())
                .map(PersonNode::getFriends)
                .orElse(List.of());
    }

      public List<Person> findAll() {
        return personRepository.findAll();
    }
      public Person save(Person person) {
        return personRepository.save(person);
    }
}
