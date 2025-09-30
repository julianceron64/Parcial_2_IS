package com.example.exercise02.Repository.mysql;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.exercise02.domain.mysql.Person;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("mysqlPersonRepository")
public interface PersonRepository extends JpaRepository<Person, Integer> {
    Optional<Person> findByEmailAndPhone(String email, String phone);
    Optional<Person> findByGlobalId(String globalId);

}
