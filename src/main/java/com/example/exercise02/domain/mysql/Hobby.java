package com.example.exercise02.domain.mysql;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "hobbies")
@Getter
@Setter
public class Hobby {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

