package com.example.exercise02.adapters;

import com.example.exercise02.domain.mysql.EventStatus;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PersonTarget {
    void savePerson(String globalId, String name, String email, String phoneNumber, LocalDate birthDate, List<Long> hobbyIds);
    Optional<String> findGlobalIdByEmailAndPhone(String email, String phone);
    void createFriendship(String globalId1, String globalId2);
    void addEvent(String globalId,String name, String location, LocalDate date);
}
