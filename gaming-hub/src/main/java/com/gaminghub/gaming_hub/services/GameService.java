package com.gaminghub.gaming_hub.services;

import com.gaminghub.gaming_hub.dto.*;
import com.gaminghub.gaming_hub.mapper.DtoMapper;
import com.gaminghub.gaming_hub.models.Game;
import com.gaminghub.gaming_hub.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    private final GameRepository repository;

    public GameService(GameRepository repository) {
        this.repository = repository;
    }

    public List<GameResponseDTO> getAllGames() {
        return repository.findAll()
                .stream()
                .map(DtoMapper::toGameResponse)
                .collect(Collectors.toList());
    }

    public GameResponseDTO getGameById(String id) {
        Game game = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Game not found"));
        return DtoMapper.toGameResponse(game);
    }

    public GameResponseDTO createGame(GameRequestDTO request) {
        Game saved = repository.save(DtoMapper.toGame(request));
        return DtoMapper.toGameResponse(saved);
    }

    public void deleteGame(String id) {
        repository.deleteById(id);
    }
}
