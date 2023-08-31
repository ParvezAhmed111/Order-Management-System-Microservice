package com.microservices.users.feignclientservice;

import com.microservices.users.entity.Orders;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value="ORDER-SERVICE" , url = "${order.base.url}")
public interface OrdersService {

    @GetMapping(value = "${order.get.order.path}")
   List<Orders> getAllOrder();


}

