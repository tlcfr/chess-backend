package ru.tlcfr.chess.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Piece {

    WHITE_PAWN(Color.WHITE, Name.PAWN),
    BLACK_PAWN(Color.BLACK, Name.PAWN),

    WHITE_ROCK(Color.WHITE, Name.ROCK),
    BLACK_ROCK(Color.BLACK, Name.ROCK),

    WHITE_KNIGHT(Color.WHITE, Name.KNIGHT),
    BLACK_KNIGHT(Color.BLACK, Name.KNIGHT),

    WHITE_BISHOP(Color.WHITE, Name.BISHOP),
    BLACK_BISHOP(Color.BLACK, Name.BISHOP),

    WHITE_QUEEN(Color.WHITE, Name.QUEEN),
    BLACK_QUEEN(Color.BLACK, Name.QUEEN),

    WHITE_KING(Color.WHITE, Name.KING),
    BLACK_KING(Color.BLACK, Name.KING),
    ;

    private final Color color;
    private final Name name;

    enum Color {
        WHITE, BLACK,
    }

    enum Name {
        PAWN, ROCK, KNIGHT, BISHOP, QUEEN, KING,
    }
}
