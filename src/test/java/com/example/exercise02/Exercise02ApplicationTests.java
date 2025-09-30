package com.example.exercise02;

import com.example.exercise02.Repository.mongo.PersonMongoRepository;
import com.example.exercise02.Repository.mysql.PersonRepository;
import com.example.exercise02.Repository.neo4j.PersonNeoRepository;
import com.example.exercise02.Services.PersonService;
import com.example.exercise02.domain.mongo.PersonDocument;
import com.example.exercise02.domain.mysql.Person;
import com.example.exercise02.domain.neo4j.PersonNode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class Exercise02ApplicationTests {

}
