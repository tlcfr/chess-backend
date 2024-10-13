CREATE TABLE arrangements
(
    id         uuid PRIMARY KEY,
    pieces     varchar[64] NOT NULL,
    game_id    uuid        NOT NULL REFERENCES games (id),
    created_at timestamp   NOT NULL
);
