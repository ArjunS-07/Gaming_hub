package com.gaminghub.gaming_hub.services;

import com.gaminghub.gaming_hub.dto.*;
import com.gaminghub.gaming_hub.mapper.DtoMapper;
import com.gaminghub.gaming_hub.models.CollectionRecord;
import com.gaminghub.gaming_hub.repository.CollectionRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CollectionRecordService {

    private final CollectionRecordRepository repository;

    public CollectionRecordService(CollectionRecordRepository repository) {
        this.repository = repository;
    }

    public List<CollectionRecordResponseDTO> getAllCollections() {
        return repository.findAll()
                .stream()
                .map(DtoMapper::toCollectionRecordResponse)
                .collect(Collectors.toList());
    }

    public CollectionRecordResponseDTO getCollectionById(String id) {
        CollectionRecord record = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Collection not found"));
        return DtoMapper.toCollectionRecordResponse(record);
    }

    public CollectionRecordResponseDTO createCollection(CollectionRecordRequestDTO request) {
        CollectionRecord saved = repository.save(DtoMapper.toCollectionRecord(request));
        return DtoMapper.toCollectionRecordResponse(saved);
    }

    public void deleteCollection(String id) {
        repository.deleteById(id);
    }
}
