package com.example.exercise02.adapters;

import java.time.LocalDate;
import java.util.List;

public interface PersonTarget {
    void savePerson(String name, LocalDate birthDate, List<String> hobbyIds);
}
