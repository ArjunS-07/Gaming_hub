package com.gaminghub.gaming_hub.repository;

import com.gaminghub.gaming_hub.models.*;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends MongoRepository<Member, String> {
    // You can add custom queries later, e.g.:
    // Optional<Member> findByPhone(String phone);
}
