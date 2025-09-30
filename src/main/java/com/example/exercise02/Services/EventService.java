package com.example.exercise02.Services;

import com.example.exercise02.Repository.mongo.EventMongoRepository;
import com.example.exercise02.Repository.mongo.PersonMongoRepository;
import com.example.exercise02.Repository.mysql.EventRepository;
import com.example.exercise02.adapters.NeoPersonAdapter;
import com.example.exercise02.adapters.SqlPersonAdapter;
import com.example.exercise02.domain.mongo.EventDocument;
import com.example.exercise02.domain.mysql.Event;

import com.example.exercise02.domain.mysql.EventStatus;
import com.example.exercise02.domain.mysql.Person;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class EventService {


    private final SqlPersonAdapter sqlAdapter;
    private final NeoPersonAdapter neoAdapter;
    private final EventMongoRepository mongoRepo;

    public EventService(SqlPersonAdapter sqlAdapter, NeoPersonAdapter neoAdapter, EventMongoRepository mongoRepo) {
        this.sqlAdapter = sqlAdapter;
        this.neoAdapter = neoAdapter;
        this.mongoRepo = mongoRepo;
    }

    public void saveEvent(String name, String location, LocalDate date) {
        UUID globalId = UUID.randomUUID();

        EventDocument mongoEvent = new EventDocument();
        mongoEvent.setGlobalId(globalId.toString());
        mongoEvent.setName(name);
        mongoEvent.setLocation(location);
        mongoEvent.setDate(date);
        mongoEvent.setStatus(EventStatus.PLANNED.toString());
        mongoRepo.save(mongoEvent);

        saveEventInSql(globalId.toString(), name, location, date);

        saveEventInNeo(globalId.toString(), name, location, date);
    }

    @Transactional("jpaTransactionManager")
    public void saveEventInSql(String globalId, String name, String location, LocalDate date) {
        sqlAdapter.addEvent(globalId, name, location, date);
    }

    @Transactional("neo4jTransactionManager")
    public void saveEventInNeo(String globalId, String name, String location, LocalDate date) {
        neoAdapter.addEvent(globalId, name, null, null);
    }

    public List<Event> findAllEvents() {
        return sqlAdapter.findAllEvents();
    }

}
