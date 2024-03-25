package com.springboot.integration.repository;

import com.springboot.integration.model.Grocery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyGroceryRepository extends MongoRepository<Grocery, String> {
}
