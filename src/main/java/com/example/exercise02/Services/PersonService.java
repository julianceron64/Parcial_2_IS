package com.example.exercise02.Services;

import com.example.exercise02.adapters.SqlPersonAdapter;
import com.example.exercise02.adapters.NeoPersonAdapter;
import com.example.exercise02.Repository.mongo.PersonMongoRepository;
import com.example.exercise02.domain.mongo.PersonDocument;
import com.example.exercise02.domain.mysql.Person;
import com.example.exercise02.domain.mysql.Hobby;
import com.example.exercise02.Repository.mysql.HobbyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class PersonService {

    private final SqlPersonAdapter sqlAdapter;
    private final NeoPersonAdapter neoAdapter;
    private final PersonMongoRepository mongoRepo;

    public PersonService(
            SqlPersonAdapter sqlAdapter,
            NeoPersonAdapter neoAdapter,
            PersonMongoRepository mongoRepo
    ) {
        this.sqlAdapter = sqlAdapter;
        this.neoAdapter = neoAdapter;
        this.mongoRepo = mongoRepo;
    }

    public void savePerson(String name, String email, String phoneNumber, LocalDate birthDate, List<Long> hobbyIds) {
        UUID globalId = UUID.randomUUID();

        PersonDocument mongoPerson = new PersonDocument();
        mongoPerson.setGlobalId(globalId);
        mongoPerson.setName(name);
        mongoPerson.setEmail(email);
        mongoPerson.setPhone(phoneNumber);
        mongoPerson.setBirthDate(birthDate);
        mongoPerson.setHobbies(hobbyIds);
        mongoRepo.save(mongoPerson);

        savePersonInSql(globalId.toString(), name, email, phoneNumber, birthDate, hobbyIds);

        savePersonInNeo(globalId.toString(), name);
    }

    @Transactional("jpaTransactionManager")
    public void savePersonInSql(String globalId, String name, String email, String phoneNumber, LocalDate birthDate, List<Long> hobbyIds) {
        sqlAdapter.savePerson(globalId, name, email, phoneNumber, birthDate, hobbyIds);
    }

    @Transactional("neo4jTransactionManager")
    public void savePersonInNeo(String globalId, String name) {
        neoAdapter.savePerson(globalId, name, null, null, null, List.of());
    }

    public List<Person> findAll() {
        return sqlAdapter.findAll();
    }
}
