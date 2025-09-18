package com.gaminghub.gaming_hub.services;

import com.gaminghub.gaming_hub.models.Transaction;
import com.gaminghub.gaming_hub.repository.TransactionRepository;
import com.gaminghub.gaming_hub.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction getTransactionById(String id) {
        return transactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction not found with id: " + id));
    }

    public Transaction createTransaction(Transaction transaction) {
        transaction.setDateTime(LocalDateTime.now());
        return transactionRepository.save(transaction);
    }

    public void deleteTransaction(String id) {
        if (!transactionRepository.existsById(id)) {
            throw new ResourceNotFoundException("Transaction not found with id: " + id);
        }
        transactionRepository.deleteById(id);
    }

    public List<Transaction> getTransactionsByMember(String memberId) {
        return transactionRepository.findByMemberId(memberId);
    }

    public List<Transaction> getTransactionsByGame(String gameId) {
        return transactionRepository.findByGameId(gameId);
    }
}
