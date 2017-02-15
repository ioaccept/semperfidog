# Users schema
 
# --- !Ups
 
CREATE TABLE Vert (
    id bigint(3),
    name varchar(255) NOT NULL,
    hturm bigint(3),
    sturm bigint(3),
    ragna bigint(3),
    pturm bigint(3),
    hand bigint(3),
    wturm bigint(3),
    balisten bigint(3),
    antimagie bigint(3),
    relikt bigint(3),
    stern bigint(3),
    gesamt bigint(3)
);

INSERT INTO Vert values (1, 'ioaccept', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);

# --- !Downs
 

