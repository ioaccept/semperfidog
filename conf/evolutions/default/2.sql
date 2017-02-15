# Users schema
 
# --- !Ups
 
CREATE TABLE Vert (
    id bigint,
    name varchar(255) NOT NULL,
    hturm bigint,
    sturm bigint,
    ragna bigint,
    pturm bigint,
    hand bigint,
    wturm bigint,
    balisten bigint,
    antimagie bigint,
    relikt bigint,
    stern bigint,
    gesamt bigint
);

INSERT INTO Vert values (1, 'ioaccept', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);

# --- !Downs
 

