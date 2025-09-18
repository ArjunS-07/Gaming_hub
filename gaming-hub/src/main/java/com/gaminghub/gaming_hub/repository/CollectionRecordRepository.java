package com.gaminghub.gaming_hub.repository;

import com.gaminghub.gaming_hub.models.CollectionRecord;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface CollectionRecordRepository extends MongoRepository<CollectionRecord, String> {
    Optional<CollectionRecord> findByDate(LocalDate date);
}
