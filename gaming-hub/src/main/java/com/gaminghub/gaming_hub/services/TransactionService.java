package com.gaminghub.gaming_hub.services;

import com.gaminghub.gaming_hub.dto.*;
import com.gaminghub.gaming_hub.mapper.DtoMapper;
import com.gaminghub.gaming_hub.models.Transaction;
import com.gaminghub.gaming_hub.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public List<TransactionResponseDTO> getAllTransactions() {
        return repository.findAll()
                .stream()
                .map(DtoMapper::toTransactionResponse)
                .collect(Collectors.toList());
    }

    public TransactionResponseDTO getTransactionById(String id) {
        Transaction transaction = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
        return DtoMapper.toTransactionResponse(transaction);
    }

    public TransactionResponseDTO createTransaction(TransactionRequestDTO request) {
        Transaction saved = repository.save(DtoMapper.toTransaction(request));
        return DtoMapper.toTransactionResponse(saved);
    }
}
