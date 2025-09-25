package com.example.exercise02.adapters;

import com.example.exercise02.Repository.mysql.EventRepository;
import com.example.exercise02.Repository.mysql.PersonRepository;
import com.example.exercise02.domain.mysql.Event;
import com.example.exercise02.domain.mysql.Person;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component("sqlPersonAdapter")
public class SqlPersonAdapter implements PersonTarget {

    private final PersonRepository personRepository;
    private final EventRepository eventRepository;

    public SqlPersonAdapter(PersonRepository personRepository, EventRepository eventRepository) {
        this.personRepository = personRepository;
        this.eventRepository = eventRepository;
    }

    @Override
    public void savePerson(String name, LocalDate birthDate, List<String> hobbyIds) {
        // Crear persona SQL
        Person sqlPerson = new Person();
        sqlPerson.setName(name);
        sqlPerson.setBirthDate(birthDate);
        sqlPerson.setHobbyIds(hobbyIds);


        personRepository.save(sqlPerson);
    }

    public List<Person> findAll(){
        return personRepository.findAll();
    }
}
