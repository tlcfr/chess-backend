package ru.tlcfr.chess.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tlcfr.chess.dto.GameDto;
import ru.tlcfr.chess.operation.game.CreateGameOperation;

@RestController
@RequestMapping("/game")
@RequiredArgsConstructor
public class GameController {

    private final CreateGameOperation createGameOperation;

    @PostMapping
    public ResponseEntity<GameDto> createGame() {
        return ResponseEntity.ok(createGameOperation.createGame());
    }
}
