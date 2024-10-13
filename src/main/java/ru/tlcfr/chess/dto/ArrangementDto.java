package ru.tlcfr.chess.dto;

import ru.tlcfr.chess.model.Piece;

import java.util.List;
import java.util.UUID;

public record ArrangementDto(UUID id,
                             List<Piece> pieces) {
}
