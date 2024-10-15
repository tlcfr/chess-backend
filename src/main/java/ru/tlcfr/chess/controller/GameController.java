package ru.tlcfr.chess.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.tlcfr.chess.dto.GameDto;
import ru.tlcfr.chess.operation.game.CreateGameOperation;
import ru.tlcfr.chess.operation.game.GetGameOperation;

import java.util.UUID;

@RestController
@RequestMapping("/game")
@RequiredArgsConstructor
public class GameController {

    private final CreateGameOperation createGameOperation;
    private final GetGameOperation getGameOperation;

    @PostMapping
    public ResponseEntity<GameDto> createGame() {
        return ResponseEntity.ok(createGameOperation.createGame());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameDto> getGame(@PathVariable UUID id) {
        return ResponseEntity.ok(getGameOperation.activate(id));
    }
}
