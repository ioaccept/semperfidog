# Users schema
 
# --- !Ups
 
CREATE TABLE Users (
    id serial PRIMARY KEY,
    name varchar(255) NOT NULL UNIQUE,
    password varchar(255),
    mentor boolean
);

INSERT INTO Users values (1, 'ioaccept', '123', true);


# --- !Downs
 
# Vert schema

# --- !Ups

CREATE TABLE Vert (
    id number(3),
    name varchar(255) NOT NULL,
    hturm number(3),
    sturm number(3),
    ragna number(3),
    pturm number(3),
    hand number(3),
    wturm number(3),
    balisten number(3),
    antimagie number(3),
    relikt number(3),
    stern number(3),
    gesamt number(3)
);

INSERT INTO Vert values (1, 'ioaccept', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);

# --- !Downs

# Gott schema

# --- !Ups

CREATE TABLE Gott (
    gottId serial Primary Key,
    userId number(3),
    gott varchar(255),
    passiv boolean,
    erweckt boolean,
    skill number(3),
    skillE number(3),
    gesamt number(3)
);

INSERT INTO Gott values (1, 1, 'Hades', true, true, 15, 2, 0);
INSERT INTO Gott values (2, 1, 'Alberich', true, true, 10, 2, 0);
INSERT INTO Gott values (3, 1, 'Ra', false, true, 11, 1, 0);
INSERT INTO Gott values (4, 1, 'Mimir', true, false, 10, 0, 0);

# --- !Downs


