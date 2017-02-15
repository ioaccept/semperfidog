# Users schema
# --- !Ups
CREATE TABLE "Users" (
    "id" serial PRIMARY KEY,
    "name" varchar(255) NOT NULL UNIQUE,
    "password" varchar(255),
    "mentor" boolean
);

INSERT INTO "Users" values (1, 'ioaccept', '123', true);

# Vert schema
# --- !Ups

CREATE TABLE "Vert" (
    "id" numeric(3),
    "name" varchar(255) NOT NULL,
    "hturm" numeric(3),
    "sturm" numeric(3),
    "ragna" numeric(3),
    "pturm" numeric(3),
    "hand" numeric(3),
    "wturm" numeric(3),
    "balisten" numeric(3),
    "antimagie" numeric(3),
    "relikt" numeric(3),
    "stern" numeric(3),
    "gesamt" numeric(3)
);
