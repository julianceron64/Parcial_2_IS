package com.example.exercise02.Services;

import com.example.exercise02.Repository.mongo.PersonMongoRepository;
import com.example.exercise02.Repository.mysql.PersonRepository;
import com.example.exercise02.adapters.NeoPersonAdapter;
import com.example.exercise02.adapters.SqlPersonAdapter;
import com.example.exercise02.domain.mongo.PersonDocument;
import com.example.exercise02.domain.neo4j.*;
import com.example.exercise02.Repository.neo4j.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class FriendshipService {

    private final SqlPersonAdapter sqlAdapter;
    private final NeoPersonAdapter neoAdapter;
    private final PersonMongoRepository mongoRepo;

    public FriendshipService(
            SqlPersonAdapter sqlAdapter,
            NeoPersonAdapter neoAdapter,
            PersonMongoRepository mongoRepo
    ) {
        this.sqlAdapter = sqlAdapter;
        this.neoAdapter = neoAdapter;
        this.mongoRepo = mongoRepo;
    }

    public void addFriend(UUID personGlobalId, String friendEmail, String friendPhone) {
        String friendGlobalId = sqlAdapter.findGlobalIdByEmailAndPhone(friendEmail, friendPhone)
                .orElseThrow(() -> new RuntimeException("Amigo no encontrado en SQL"));

        UUID friendUuid = UUID.fromString(friendGlobalId);

        PersonDocument person = mongoRepo.findByGlobalId(personGlobalId)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada en Mongo"));

        PersonDocument friend = mongoRepo.findByGlobalId(friendUuid)
                .orElseThrow(() -> new RuntimeException("Amigo no encontrado en Mongo"));

        if (!person.getFriends().contains(friendUuid)) {
            person.getFriends().add(friendUuid);
        }
        if (!friend.getFriends().contains(personGlobalId)) {
            friend.getFriends().add(personGlobalId);
        }

        mongoRepo.save(person);
        mongoRepo.save(friend);

        // 5. Crear relaciones en SQL y Neo4j
        createFriendshipSql(personGlobalId.toString(), friendGlobalId);
        createFriendshipNeo(personGlobalId.toString(), friendGlobalId);
    }

    @Transactional("jpaTransactionManager")
    public void createFriendshipSql(String personGlobalId, String friendGlobalId) {
        sqlAdapter.createFriendship(personGlobalId, friendGlobalId);
    }

    @Transactional("neo4jTransactionManager")
    public void createFriendshipNeo(String personGlobalId, String friendGlobalId) {
        neoAdapter.createFriendship(personGlobalId, friendGlobalId);
    }
}
