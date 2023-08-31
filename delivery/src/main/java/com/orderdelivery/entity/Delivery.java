package com.orderdelivery.entity;

import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import lombok.*;
import org.bson.types.ObjectId;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@MappedEntity("delivery")
public class Delivery {

    @Id
    private ObjectId id;

    private String orderId;
    private String deliveryStatus;
    private String deliveryBy;
    private String deliveryDate;
}
