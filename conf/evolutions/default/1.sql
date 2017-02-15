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
    id numeric(3),
    name varchar(255) NOT NULL,
    hturm numeric(3),
    sturm numeric(3),
    ragna numeric(3),
    pturm numeric(3),
    hand numeric(3),
    wturm numeric(3),
    balisten numeric(3),
    antimagie numeric(3),
    relikt numeric(3),
    stern numeric(3),
    gesamt numeric(3)
);

INSERT INTO Vert values (1, 'ioaccept', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);

# --- !Downs

# Gott schema

# --- !Ups

CREATE TABLE Gott (
    gottId serial Primary Key,
    userId numeric(3),
    gott varchar(255),
    passiv boolean,
    erweckt boolean,
    skill numeric(3),
    skillE numeric(3),
    gesamt numeric(3)
);

INSERT INTO Gott values (1, 1, 'Hades', true, true, 15, 2, 0);
INSERT INTO Gott values (2, 1, 'Alberich', true, true, 10, 2, 0);
INSERT INTO Gott values (3, 1, 'Ra', false, true, 11, 1, 0);
INSERT INTO Gott values (4, 1, 'Mimir', true, false, 10, 0, 0);

# --- !Downs


