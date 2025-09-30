-- Tabla persons
CREATE TABLE persons (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    global_id CHAR(36) NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL,
    birth_date DATE NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    phone VARCHAR(20) NOT NULL UNIQUE,
    neo4j_node_id BIGINT
);


CREATE TABLE person_hobby_ids (
    person_id BIGINT NOT NULL,
    hobby VARCHAR(255),
    CONSTRAINT fk_person_hobby FOREIGN KEY (person_id) REFERENCES persons(id)
);

-- Tabla events
CREATE TABLE events (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    event_date DATE NOT NULL,
    location VARCHAR(100) NOT NULL,
    status ENUM('PLANNED','ONGOING','COMPLETED') NOT NULL
);

-- Relación ManyToMany
CREATE TABLE person_event (
    person_id BIGINT NOT NULL,
    event_id INT NOT NULL,
    PRIMARY KEY (person_id, event_id),
    CONSTRAINT fk_person FOREIGN KEY (person_id) REFERENCES persons(id) ON DELETE CASCADE,
    CONSTRAINT fk_event FOREIGN KEY (event_id) REFERENCES events(id) ON DELETE CASCADE
);
