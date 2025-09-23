
CREATE TABLE Person (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    birth_date DATE NOT NULL,
    hobbies JSON
);


CREATE TABLE Event (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    event_date DATE NOT NULL,
    location VARCHAR(100) NOT NULL,
    start_time TIME NOT NULL,
    end_time TIME NOT NULL,
    status ENUM('PLANNED', 'ONGOING', 'COMPLETED') NOT NULL
);

-- ====================
-- Relación Person - Event (ManyToMany)
-- ====================
CREATE TABLE Person_Events (
    person_id INT NOT NULL,
    event_id INT NOT NULL,
    PRIMARY KEY (person_id, event_id),
    CONSTRAINT fk_person_event
        FOREIGN KEY (person_id) REFERENCES Person(id)
        ON DELETE CASCADE,
    CONSTRAINT fk_event_person
        FOREIGN KEY (event_id) REFERENCES Event(id)
        ON DELETE CASCADE
);
