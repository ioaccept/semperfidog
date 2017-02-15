# Users schema
 
# --- !Ups
 
CREATE TABLE Users (
    id serial PRIMARY KEY,,,,,
    name varchar(255) NOT NULL UNIQUE,
    password varchar(255),
    mentor boolean
);

INSERT INTO Users values (1, 'ioaccept', '123', true);

