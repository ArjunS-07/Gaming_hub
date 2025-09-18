package com.gaminghub.gaming_hub.repository;

import com.gaminghub.gaming_hub.models.Game;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends MongoRepository<Game, String> {
    // Example: List<Game> findByNameContaining(String keyword);
}
