# Users schema
 
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
 

