package com.example.exercise02;

import com.example.exercise02.Repository.mysql.EventRepository;
import com.example.exercise02.Repository.mysql.PersonRepository;
import com.example.exercise02.Services.PersonService;
import com.example.exercise02.domain.mongo.Hobby;
import com.example.exercise02.domain.mysql.Person;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class Exercise02Application {

	public static void main(String[] args) {
		SpringApplication.run(Exercise02Application.class, args);
	}

}
