package ru.tlcfr.chess.operation.game;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.tlcfr.chess.dto.GameDto;
import ru.tlcfr.chess.mapper.GameMapper;
import ru.tlcfr.chess.model.Arrangement;
import ru.tlcfr.chess.model.Game;
import ru.tlcfr.chess.model.Piece;
import ru.tlcfr.chess.repository.GameRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import static ru.tlcfr.chess.helper.SessionHelper.getSessionId;

@Service
@RequiredArgsConstructor
public class CreateGameOperation {

    private final GameRepository gameRepository;
    private final GameMapper gameMapper;

    public GameDto activate() {
        Game game = new Game();

        Arrangement arrangement = new Arrangement();
        arrangement.setPieces(buildArrangementPieces());
        arrangement.setGame(game);

        game.setArrangements(List.of(arrangement));
        game.setWhitePlayerId(getSessionId());

        return gameMapper.toDto(gameRepository.save(game));
    }

    private List<Piece> buildArrangementPieces() {
        return Stream.of(
                        buildValuablePiecesRank(Piece.Color.BLACK),
                        buildPawnsRank(Piece.Color.BLACK),
                        buildEmptyRank(),
                        buildEmptyRank(),
                        buildEmptyRank(),
                        buildEmptyRank(),
                        buildPawnsRank(Piece.Color.WHITE),
                        buildValuablePiecesRank(Piece.Color.WHITE)
                )
                .flatMap(Collection::stream)
                .toList();
    }

    private List<Piece> buildValuablePiecesRank(Piece.Color color) {
        return Stream.of(
                        Piece.Name.ROCK,
                        Piece.Name.KNIGHT,
                        Piece.Name.BISHOP,
                        Piece.Name.QUEEN,
                        Piece.Name.KING,
                        Piece.Name.BISHOP,
                        Piece.Name.KNIGHT,
                        Piece.Name.ROCK
                )
                .map(name -> Piece.from(color, name))
                .toList();
    }

    private List<Piece> buildPawnsRank(Piece.Color color) {
        return Stream.generate(() -> Piece.Name.PAWN)
                .limit(8)
                .map(name -> Piece.from(color, name))
                .toList();
    }

    private List<Piece> buildEmptyRank() {
        return Stream.generate(() -> (Piece) null)
                .limit(8)
                .toList();
    }
}
