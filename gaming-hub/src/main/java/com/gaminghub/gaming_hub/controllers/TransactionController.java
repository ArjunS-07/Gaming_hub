package com.gaminghub.gaming_hub.controllers;

import com.gaminghub.gaming_hub.models.Transaction;
import com.gaminghub.gaming_hub.services.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable String id) {
        return ResponseEntity.ok(transactionService.getTransactionById(id));
    }

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        return ResponseEntity.ok(transactionService.createTransaction(transaction));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable String id) {
        transactionService.deleteTransaction(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/member/{memberId}")
    public List<Transaction> getTransactionsByMember(@PathVariable String memberId) {
        return transactionService.getTransactionsByMember(memberId);
    }

    @GetMapping("/game/{gameId}")
    public List<Transaction> getTransactionsByGame(@PathVariable String gameId) {
        return transactionService.getTransactionsByGame(gameId);
    }
}
