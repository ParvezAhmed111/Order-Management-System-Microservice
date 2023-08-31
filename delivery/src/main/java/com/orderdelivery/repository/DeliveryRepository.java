package com.orderdelivery.repository;

import com.orderdelivery.entity.Delivery;
import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.reactive.ReactorCrudRepository;
import org.bson.types.ObjectId;
import reactor.core.publisher.Mono;

@MongoRepository
public interface DeliveryRepository extends ReactorCrudRepository<Delivery, ObjectId> {

    Mono<Delivery> findByOrderId(String orderId);
}
