package ru.tlcfr.chess.dto;

import java.util.List;
import java.util.UUID;

public record GameDto(UUID id,
                      List<ArrangementDto> arrangements) {
}
