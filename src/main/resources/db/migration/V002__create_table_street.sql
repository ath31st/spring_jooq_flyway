CREATE TABLE street
(
    id      INTEGER PRIMARY KEY,
    name    VARCHAR(300) NOT NULL,
    city_id INTEGER,
    FOREIGN KEY (city_id) REFERENCES city (id)
);