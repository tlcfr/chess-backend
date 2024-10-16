package ru.tlcfr.chess.operation.game;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.tlcfr.chess.dto.GameDto;
import ru.tlcfr.chess.mapper.GameMapper;
import ru.tlcfr.chess.model.Game;
import ru.tlcfr.chess.repository.GameRepository;

import java.util.UUID;

import static ru.tlcfr.chess.helper.SessionHelper.getSessionId;

@Service
@RequiredArgsConstructor
public class GetGameOperation {

    private final GameRepository gameRepository;
    private final GameMapper gameMapper;

    public GameDto activate(UUID id) {
        Game game = gameRepository.findById(id)
                .orElseThrow();

        UUID sessionId = getSessionId();
        if (!game.getWhitePlayerId().equals(sessionId) && game.getBlackPlayerId() == null) {
            game.setBlackPlayerId(sessionId);
            game = gameRepository.save(game);
        }

        return gameMapper.toDto(game);
    }
}
