package com.example.exercise02.Services;

import com.example.exercise02.adapters.SqlPersonAdapter;
import com.example.exercise02.adapters.NeoPersonAdapter;
import com.example.exercise02.Repository.mongo.PersonMongoRepository;
import com.example.exercise02.domain.mongo.PersonDocument;
import com.example.exercise02.domain.mysql.Person;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

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

    public void savePerson(String name, LocalDate birthDate, List<String> hobbyIds) {
        PersonDocument mongoPerson = new PersonDocument();
        mongoPerson.setName(name);
        mongoPerson.setBirthDate(birthDate);
        mongoPerson.setHobbies(hobbyIds);
        mongoRepo.save(mongoPerson);

        savePersonInSql(name, birthDate, hobbyIds);

        savePersonInNeo(name);
    }

    @Transactional("jpaTransactionManager")
    public void savePersonInSql(String name, LocalDate birthDate, List<String> hobbyIds) {
        sqlAdapter.savePerson(name, birthDate, hobbyIds);
    }

    @Transactional("neo4jTransactionManager")
    public void savePersonInNeo(String name) {
        neoAdapter.savePerson(name, null, List.of());
    }

    public List<Person> findAll() {
        return sqlAdapter.findAll();
    }
}
