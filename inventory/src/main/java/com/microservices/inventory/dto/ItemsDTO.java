package com.microservices.inventory.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemsDTO {

    private String itemId;
    private String itemName;
    private int quantityAvailable;
    private String supplier;
    private String category;
    private String description;
    private Double price;
}
