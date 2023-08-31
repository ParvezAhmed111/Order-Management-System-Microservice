package com.microservice.order.dto;

import com.microservice.order.model.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private String id;
    private String userName;
    private String itemId;
    private String itemName;
    private String description;
    private int quantity;
    private Date orderDate;
    private Address address;
}
