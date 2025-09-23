package com.example.exercise02;

import com.example.exercise02.Services.PersonService;
import com.example.exercise02.domain.mongo.Hobby;
import com.example.exercise02.domain.mysql.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class Exercise02ApplicationTests {

    @Autowired
    private PersonService personService;

    @Test
    void testBackendIntegration() {
        Person ana = personService.createPerson(
                "Ana",
                LocalDate.of(2000, 5, 10),
                List.of("futbol", "ajedrez")
        );

        Person luis = personService.createPerson(
                "Luis",
                LocalDate.of(1998, 8, 15),
                List.of("futbol", "pintura")
        );

        System.out.println("---- Hobbies de Ana ----");
        List<Hobby> hobbiesAna = personService.getHobbies(ana);
        hobbiesAna.forEach(h -> System.out.println(h.getName() + " - " + h.getDescription()));

        System.out.println("---- Personas con hobby 'futbol' ----");
        personService.findPersonsByHobby("futbol")
                .forEach(p -> System.out.println(p.getName()));

        System.out.println("---- Amigos de Ana (Neo4j) ----");
        personService.getFriends(ana).forEach(f -> System.out.println(f.getName()));
        }
}
