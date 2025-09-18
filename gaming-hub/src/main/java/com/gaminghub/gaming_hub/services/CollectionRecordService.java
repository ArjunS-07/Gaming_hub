package com.gaminghub.gaming_hub.services;

import com.gaminghub.gaming_hub.models.CollectionRecord;
import com.gaminghub.gaming_hub.repository.CollectionRecordRepository;
import com.gaminghub.gaming_hub.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CollectionRecordService {

    private final CollectionRecordRepository repository;

    public CollectionRecordService(CollectionRecordRepository repository) {
        this.repository = repository;
    }

    public List<CollectionRecord> getAllCollections() {
        return repository.findAll();
    }

    public CollectionRecord getCollectionById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Collection record not found with id: " + id));
    }

    public CollectionRecord getCollectionByDate(LocalDate date) {
        return repository.findByDate(date)
                .orElseThrow(() -> new ResourceNotFoundException("Collection record not found for date: " + date));
    }

    public CollectionRecord createOrUpdateCollection(LocalDate date, Double amount) {
        CollectionRecord record = repository.findByDate(date).orElse(new CollectionRecord(date, 0.0));
        record.setAmount(record.getAmount() + amount); // add to existing total
        return repository.save(record);
    }

    public void deleteCollection(String id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Collection record not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
