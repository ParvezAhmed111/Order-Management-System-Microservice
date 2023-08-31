package com.orderdelivery.service;

import com.orderdelivery.dto.DeliveryResponse;
import reactor.core.publisher.Mono;

public interface DeliveryService {

    Mono<DeliveryResponse> getDeliveryStatus(String orderId);
    Mono<DeliveryResponse> createDelivery(String orderId);
}
