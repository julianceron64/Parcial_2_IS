package com.example.exercise02.Repository.mysql;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.exercise02.domain.mysql.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    
}
