package com.microservices.inventory.repository;

import com.microservices.inventory.entity.Items;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends MongoRepository<Items,String> {

}
