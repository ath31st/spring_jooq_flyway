CREATE TABLE houses
(
    id            INTEGER PRIMARY KEY,
    house_number  VARCHAR(10) NOT NULL,
    date_of_build DATE,
    street_id     INTEGER,
    FOREIGN KEY (street_id) REFERENCES streets (id)
);
