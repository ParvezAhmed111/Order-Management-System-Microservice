package com.microservices.users.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    @JsonProperty("id")
    private String id;
    @JsonProperty("itemId")
    private String itemId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("quantity")
    private int quantity;
    @JsonProperty("orderDate")
    private String orderDate;
    @JsonProperty("address")
    private Address address;
}
