package ru.tlcfr.chess.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.tlcfr.chess.dto.GameDto;
import ru.tlcfr.chess.model.Game;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface GameMapper {

    GameDto toDto(Game game);
}
