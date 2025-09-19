package com.gaminghub.gaming_hub.controllers;

import com.gaminghub.gaming_hub.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import com.gaminghub.gaming_hub.services.CollectionRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/collections")
public class CollectionRecordController {

    private final CollectionRecordService service;
    private static final Logger logger = LoggerFactory.getLogger(CollectionRecordController.class);

    public CollectionRecordController(CollectionRecordService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CollectionRecordResponseDTO>> getAllCollections() {
        return ResponseEntity.ok(service.getAllCollections());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CollectionRecordResponseDTO> getCollectionById(@PathVariable String id) {
        return ResponseEntity.ok(service.getCollectionById(id));
    }

    @PostMapping
    public ResponseEntity<CollectionRecordResponseDTO> createCollection(@RequestBody CollectionRecordRequestDTO request) {
        return ResponseEntity.ok(service.createCollection(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCollection(@PathVariable String id) {
        service.deleteCollection(id);
        return ResponseEntity.noContent().build();
    }
}
