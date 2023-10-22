CREATE TABLE house
(
    id            INTEGER PRIMARY KEY,
    house_number  INTEGER NOT NULL,
    date_of_build DATE,
    street_id     INTEGER,
    FOREIGN KEY (street_id) REFERENCES street (id)
);
