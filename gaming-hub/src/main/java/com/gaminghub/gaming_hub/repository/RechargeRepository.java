package com.gaminghub.gaming_hub.repository;

import com.gaminghub.gaming_hub.models.Recharge;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RechargeRepository extends MongoRepository<Recharge, String> {
}
