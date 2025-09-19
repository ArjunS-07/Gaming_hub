package com.gaminghub.gaming_hub.controllers;

import com.gaminghub.gaming_hub.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import com.gaminghub.gaming_hub.services.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/games")
public class GameController {

    private final GameService service;
    private static final Logger logger = LoggerFactory.getLogger(GameController.class);

    public GameController(GameService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<GameResponseDTO>> getAllGames() {
        return ResponseEntity.ok(service.getAllGames());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameResponseDTO> getGameById(@PathVariable String id) {
        return ResponseEntity.ok(service.getGameById(id));
    }

    @PostMapping
    public ResponseEntity<GameResponseDTO> createGame(@RequestBody GameRequestDTO request) {
        return ResponseEntity.ok(service.createGame(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGame(@PathVariable String id) {
        service.deleteGame(id);
        return ResponseEntity.noContent().build();
    }
}
