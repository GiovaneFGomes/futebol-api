DROP TABLE IF EXISTS teams;

CREATE TABLE teams
(
    id INTEGER,
    name_team VARCHAR(250) NOT NULL,
    name_stadium VARCHAR(50) NOT NULL,
    name_country VARCHAR(50) NOT NULL
);