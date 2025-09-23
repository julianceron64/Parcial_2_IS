package com.example.exercise02.Repository.mysql;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.exercise02.domain.mysql.Person;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    List<Person> findByHobbyIdsContains(String hobbyId);
}
