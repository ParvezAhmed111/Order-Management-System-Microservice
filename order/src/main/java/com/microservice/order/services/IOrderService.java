package com.microservice.order.services;

import com.microservice.order.dto.AddressDto;
import com.microservice.order.dto.OrderDto;
import com.microservice.order.model.Address;
import com.microservice.order.model.Order;
import org.aspectj.weaver.ast.Or;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IOrderService {
    Mono<Order> createOrder(OrderDto orderDto);
    Flux<Order> getAllOrders();
    Mono<Order> getOrderById(String id);
    Mono<Order> updateAddress(String id, AddressDto addressDto);
    Mono<Void> deleteOrder(String id);
}
