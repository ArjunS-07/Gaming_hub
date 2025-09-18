package com.gaminghub.gaming_hub.controllers;

import com.gaminghub.gaming_hub.models.CollectionRecord;
import com.gaminghub.gaming_hub.services.CollectionRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/collections")
public class CollectionRecordController {

    private final CollectionRecordService service;

    public CollectionRecordController(CollectionRecordService service) {
        this.service = service;
    }

    @GetMapping
    public List<CollectionRecord> getAllCollections() {
        return service.getAllCollections();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CollectionRecord> getCollectionById(@PathVariable String id) {
        return ResponseEntity.ok(service.getCollectionById(id));
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<CollectionRecord> getCollectionByDate(@PathVariable String date) {
        return ResponseEntity.ok(service.getCollectionByDate(LocalDate.parse(date)));
    }

    @PostMapping
    public ResponseEntity<CollectionRecord> createOrUpdateCollection(
            @RequestParam String date,
            @RequestParam Double amount) {
        LocalDate localDate = LocalDate.parse(date);
        return ResponseEntity.ok(service.createOrUpdateCollection(localDate, amount));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCollection(@PathVariable String id) {
        service.deleteCollection(id);
        return ResponseEntity.noContent().build();
    }
}
