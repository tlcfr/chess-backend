package ru.tlcfr.chess.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Piece {

    WHITE_PAWN(Color.WHITE, Name.PAWN, "wP"),
    BLACK_PAWN(Color.BLACK, Name.PAWN, "bP"),

    WHITE_ROCK(Color.WHITE, Name.ROCK, "wR"),
    BLACK_ROCK(Color.BLACK, Name.ROCK, "bR"),

    WHITE_KNIGHT(Color.WHITE, Name.KNIGHT, "wN"),
    BLACK_KNIGHT(Color.BLACK, Name.KNIGHT, "bN"),

    WHITE_BISHOP(Color.WHITE, Name.BISHOP, "wB"),
    BLACK_BISHOP(Color.BLACK, Name.BISHOP, "bB"),

    WHITE_QUEEN(Color.WHITE, Name.QUEEN, "wQ"),
    BLACK_QUEEN(Color.BLACK, Name.QUEEN, "bQ"),

    WHITE_KING(Color.WHITE, Name.KING, "wK"),
    BLACK_KING(Color.BLACK, Name.KING, "bK"),
    ;

    private final Color color;
    private final Name name;
    private final String shortName;

    public static Piece from(Color color, Name name) {
        for (Piece piece : values()) {
            if (piece.color == color && piece.name == name) {
                return piece;
            }
        }
        throw new IllegalStateException("Illegal piece");
    }

    public enum Color {
        WHITE, BLACK,
    }

    public enum Name {
        PAWN, ROCK, KNIGHT, BISHOP, QUEEN, KING,
    }
}
