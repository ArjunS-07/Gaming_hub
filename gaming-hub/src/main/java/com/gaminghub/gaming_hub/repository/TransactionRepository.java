package com.gaminghub.gaming_hub.repository;

import com.gaminghub.gaming_hub.models.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends MongoRepository<Transaction, String> {
    List<Transaction> findByMemberId(String memberId);
    List<Transaction> findByGameId(String gameId);
}
