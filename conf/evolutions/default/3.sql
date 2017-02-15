# Users schema
 
# --- !Ups
 
CREATE TABLE Gott (
    gottId serial Primary Key,
    userId bigint(3),
    gott varchar(255),
    passiv boolean,
    erweckt boolean,
    skill bigint(3),
    skillE bigint(3),
    gesamt bigint(3)
);

INSERT INTO Gott values (1, 1, 'Hades', true, true, 15, 2, 0);
INSERT INTO Gott values (2, 1, 'Alberich', true, true, 10, 2, 0);
INSERT INTO Gott values (3, 1, 'Ra', false, true, 11, 1, 0);
INSERT INTO Gott values (4, 1, 'Mimir', true, false, 10, 0, 0);

# --- !Downs
 
