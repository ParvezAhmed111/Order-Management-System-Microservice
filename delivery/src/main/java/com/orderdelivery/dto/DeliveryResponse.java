package com.orderdelivery.dto;

import io.micronaut.core.annotation.Introspected;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Introspected
public class DeliveryResponse {

    private String orderId;
    private String deliveryStatus;
    private String deliveryBy;
    private String deliveryDate;
}
