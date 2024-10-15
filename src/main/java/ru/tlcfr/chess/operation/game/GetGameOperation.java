package ru.tlcfr.chess.operation.game;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.tlcfr.chess.dto.GameDto;
import ru.tlcfr.chess.mapper.GameMapper;
import ru.tlcfr.chess.repository.GameRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetGameOperation {

    private final GameRepository gameRepository;
    private final GameMapper gameMapper;

    public GameDto activate(UUID id) {
        return gameRepository.findById(id)
                .map(gameMapper::toDto)
                .orElseThrow();
    }
}
