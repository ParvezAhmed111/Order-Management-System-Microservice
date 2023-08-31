package com.microservices.users.dto;

import com.microservices.users.entity.Orders;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersDTO {
    private String userId;
    private String userName;
    private String address;
    private List<Orders> myOrders;
}

