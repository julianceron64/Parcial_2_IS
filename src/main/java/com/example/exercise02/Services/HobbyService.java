package com.example.exercise02.Services;

import com.example.exercise02.Repository.mysql.HobbyRepository;
import com.example.exercise02.domain.mysql.Hobby;
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

}
