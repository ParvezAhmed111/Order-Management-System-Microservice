package com.orderdelivery.controller;

import com.orderdelivery.dto.DeliveryResponse;
import com.orderdelivery.service.DeliveryService;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.inject.Inject;
import lombok.NonNull;
import reactor.core.publisher.Mono;

@Controller("/delivery")
public class DeliveryController {

    @Inject
    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @Get("/{order-id}")
    @Status(HttpStatus.ACCEPTED)
    @Operation(summary = "Get Delivery Status by Order ID")
    Mono<DeliveryResponse> getDeliveryStatus(@NonNull @PathVariable("order-id") String orderId) {
        return deliveryService.getDeliveryStatus(orderId);
    }

    @Post("/{order-id}")
    @Status(HttpStatus.ACCEPTED)
    @Operation(summary = "Create Delivery by Order ID")
    Mono<DeliveryResponse> createDelivery(@NonNull @PathVariable("order-id") String orderId) {
        return deliveryService.createDelivery(orderId);
    }
}
