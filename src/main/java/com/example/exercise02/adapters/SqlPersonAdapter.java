package com.example.exercise02.adapters;

import com.example.exercise02.Repository.mysql.EventRepository;
import com.example.exercise02.Repository.mysql.HobbyRepository;
import com.example.exercise02.Repository.mysql.PersonRepository;
import com.example.exercise02.domain.mysql.Hobby;
import com.example.exercise02.domain.mysql.Person;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component("sqlPersonAdapter")
public class SqlPersonAdapter implements PersonTarget {

    private final PersonRepository personRepository;
    private final EventRepository eventRepository;
    private final HobbyRepository hobbyRepository;

    public SqlPersonAdapter(
            PersonRepository personRepository,
            EventRepository eventRepository,
            HobbyRepository hobbyRepository
    ) {
        this.personRepository = personRepository;
        this.eventRepository = eventRepository;
        this.hobbyRepository = hobbyRepository;
    }

    public List<Hobby> findAllHobbies() {
        return hobbyRepository.findAll();
    }


    @Override
    public void savePerson(
            String globalId,
            String name,
            String email,
            String phoneNumber,
            LocalDate birthDate,
            List<Long> hobbyIds
    ) {
        Person sqlPerson = new Person();
        sqlPerson.setGlobalId(globalId);
        sqlPerson.setName(name);
        sqlPerson.setEmail(email);
        sqlPerson.setPhone(phoneNumber);
        sqlPerson.setBirthDate(birthDate);

        List<Hobby> hobbies = hobbyRepository.findAllById(
                hobbyIds.stream().map(Long::valueOf).toList()
        );
        sqlPerson.setHobbies(hobbies);

        personRepository.save(sqlPerson);
    }

    @Override
    public Optional<String> findGlobalIdByEmailAndPhone(String email, String phone) {
        return personRepository.findByEmailAndPhone(email, phone)
                .map(Person::getGlobalId);
    }

    @Override
    public void createFriendship(String globalId1, String globalId2) {
        Person p1 = personRepository.findByGlobalId(globalId1)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada: " + globalId1));
        Person p2 = personRepository.findByGlobalId(globalId2)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada: " + globalId2));

        // relación bidireccional
        p1.getFriends().add(p2);
        p2.getFriends().add(p1);

        personRepository.save(p1);
        personRepository.save(p2);
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }
}
