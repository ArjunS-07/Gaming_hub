package com.gaminghub.gaming_hub.services;

import com.gaminghub.gaming_hub.models.Game;
import com.gaminghub.gaming_hub.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public Optional<Game> getGameById(String id) {
        return gameRepository.findById(id);
    }

    public Game addGame(Game game) {
        return gameRepository.save(game);
    }

    public Game updateGame(String id, Game updatedGame) {
        return gameRepository.findById(id)
                .map(existing -> {
                    existing.setName(updatedGame.getName());
                    existing.setPrice(updatedGame.getPrice());
                    existing.setDescription(updatedGame.getDescription());
                    return gameRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Game not found with id: " + id));
    }

    public void deleteGame(String id) {
        gameRepository.deleteById(id);
    }
}
