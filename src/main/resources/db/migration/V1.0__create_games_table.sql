CREATE TABLE games
(
    id              uuid PRIMARY KEY,
    white_player_id uuid NOT NULL,
    black_player_id uuid
);
