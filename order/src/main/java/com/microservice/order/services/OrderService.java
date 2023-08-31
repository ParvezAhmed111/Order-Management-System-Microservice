package com.microservice.order.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.order.constants.ServiceConstants;
import com.microservice.order.dto.AddressDto;
import com.microservice.order.dto.OrderDto;
import com.microservice.order.exception.OrderServiceErrorHandler;
import com.microservice.order.exception.OrderServiceException;
import com.microservice.order.feignclientservice.DeliveryService;
import com.microservice.order.feignclientservice.InventoryService;
import com.microservice.order.model.Address;
import com.microservice.order.model.Order;
import com.microservice.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

@Service
public class OrderService implements IOrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private DeliveryService deliveryService;

    @Autowired
    private OrderServiceErrorHandler orderServiceErrorHandler;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public Mono<Order> createOrder(OrderDto orderDto) {
        Order order= objectMapper.convertValue(orderDto, Order.class);
        String itemId= order.getItemId();
        int quantity = order.getQuantity();
        order.setOrderDate(new Date());
        String orderStatus = inventoryService.checkAvailability(itemId, quantity);

        if(orderStatus==null) return Mono.error(new OrderServiceException(String.format(ServiceConstants.ITEM_NOT_FOUND, itemId)));

        if (orderStatus.equals(ServiceConstants.TRUE)) {
            return orderRepository.save(order)
                    .doOnSuccess(orderDetails -> deliveryService.initiateDeliveryCreation(orderDetails.getId()));
        }
        return Mono.error(new OrderServiceException(String.format(ServiceConstants.INSUFFICIENT_QUANTITY, itemId)));
    }

    @Override
    public Flux<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Mono<Order> getOrderById(String id){
        return orderRepository.findById(id)
                .switchIfEmpty(Mono.error(new OrderServiceException(String.format(ServiceConstants.ORDER_NOT_FOUND, id))));
    }

    @Override
    public Mono<Order> updateAddress(String id, AddressDto addressDto) {
        Address address= objectMapper.convertValue(addressDto, Address.class);
        return orderRepository.findById(id)
                .switchIfEmpty(Mono.error(new OrderServiceException(String.format(ServiceConstants.ORDER_NOT_FOUND2, id))))
                .map(order -> {
                    order.setAddress(address);
                    return order;
                })
                .flatMap(orderRepository::save);
    }

    @Override
    public Mono<Void> deleteOrder(String id) {
        return orderRepository.deleteById(id);
    }
}
