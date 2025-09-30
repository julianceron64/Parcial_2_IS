package com.example.exercise02.Repository.mysql;

import com.example.exercise02.domain.mysql.Hobby;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface HobbyRepository extends JpaRepository<Hobby, Long> {

}

