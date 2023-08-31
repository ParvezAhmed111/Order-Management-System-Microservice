package com.orderdelivery.service.impl;

import com.orderdelivery.dto.DeliveryResponse;
import com.orderdelivery.entity.Delivery;
import com.orderdelivery.repository.DeliveryRepository;
import com.orderdelivery.service.DeliveryService;
import com.orderdelivery.util.Constants;
import com.orderdelivery.util.Utility;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.exceptions.HttpStatusException;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import reactor.core.publisher.Mono;

@Singleton
public class DeliveryServiceImpl implements DeliveryService {

    @Inject
    private final DeliveryRepository deliveryRepository;

    public DeliveryServiceImpl(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    @Override
    public Mono<DeliveryResponse> getDeliveryStatus(String orderId) {

        return deliveryRepository.findByOrderId(orderId)
                .map(delivery -> DeliveryResponse.builder()
                        .orderId(orderId)
                        .deliveryStatus(delivery.getDeliveryStatus())
                        .deliveryBy(delivery.getDeliveryBy())
                        .deliveryDate(delivery.getDeliveryDate())
                        .build())
                .switchIfEmpty(Mono.error(new HttpStatusException(HttpStatus.NOT_FOUND, "Delivery details not found")));
    }

    @Override
    public Mono<DeliveryResponse> createDelivery(String orderId) {
        return deliveryRepository.save(Delivery.builder()
                        .orderId(orderId)
                        .deliveryStatus(Constants.DELIVERY_INITIATED)
                        .deliveryBy(Utility.assignDeliveryPerson())
                        .deliveryDate(Utility.laterDeliveryDate())
                        .build())
                .map(delivery -> DeliveryResponse.builder()
                        .orderId(orderId)
                        .deliveryStatus(delivery.getDeliveryStatus())
                        .deliveryBy(delivery.getDeliveryBy())
                        .deliveryDate(delivery.getDeliveryDate())
                        .build());
    }
}
