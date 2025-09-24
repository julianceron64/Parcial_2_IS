package com.example.exercise02.Repository.mysql;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.exercise02.domain.mysql.Event;

public interface EventRepository extends JpaRepository<Event, Integer> {
}
