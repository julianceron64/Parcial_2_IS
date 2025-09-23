package com.example.exercise02.Services;

import com.example.exercise02.Repository.mongo.HobbyRepository;
import com.example.exercise02.domain.mongo.Hobby;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HobbyService {

    private final HobbyRepository hobbyRepository;

    public HobbyService(HobbyRepository hobbyRepository) {
        this.hobbyRepository = hobbyRepository;
    }

    public List<Hobby> findAll() {
        return hobbyRepository.findAll();
    }

    public Hobby save(Hobby hobby) {
        return hobbyRepository.save(hobby);
    }
}
