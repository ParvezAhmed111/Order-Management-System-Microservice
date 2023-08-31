package com.microservices.inventory.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document("inventory")
public class Items {

    @Id
    private String itemId;
    private String itemName;
    private int quantityAvailable;
    private String supplier;
    private String category;
    private String description;
    private Double price;
    private String date;

}
