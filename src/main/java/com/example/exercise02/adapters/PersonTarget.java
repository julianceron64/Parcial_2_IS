package com.example.exercise02.adapters;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PersonTarget {
    void savePerson(String globalId, String name, String email, String phoneNumber, LocalDate birthDate, List<Long> hobbyIds);
    Optional<String> findGlobalIdByEmailAndPhone(String email, String phone);
    void createFriendship(String globalId1, String globalId2);
}
