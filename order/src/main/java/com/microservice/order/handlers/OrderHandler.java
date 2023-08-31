package com.microservice.order.handlers;

import com.microservice.order.constants.ServiceConstants;
import com.microservice.order.dto.AddressDto;
import com.microservice.order.dto.OrderDto;
import com.microservice.order.exception.OrderServiceErrorHandler;
import com.microservice.order.model.Order;
import com.microservice.order.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class OrderHandler {
    @Autowired
    private IOrderService orderService;

    @Autowired
    OrderServiceErrorHandler orderServiceErrorHandler;

    public Mono<ServerResponse> createOrder(ServerRequest request) {
        return request.bodyToMono(OrderDto.class)
                .flatMap(requestBody -> orderService.createOrder(requestBody)
                        .flatMap(responseBody -> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(responseBody))
                        .onErrorResume(error-> orderServiceErrorHandler.orderResponseErrorHandler(error)));
    }


    public Mono<ServerResponse> getAllOrders(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(orderService.getAllOrders(), Order.class);
    }

    public Mono<ServerResponse> getOrderById(ServerRequest request) {
        String id= request.pathVariable(ServiceConstants.ID);
        Mono<Order> orderMono= orderService.getOrderById(id);
        return orderMono.flatMap(requestBody-> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(orderMono, Order.class))
                .onErrorResume(error -> orderServiceErrorHandler.orderResponseErrorHandler(error));
    }

    public Mono<ServerResponse> updateAddress(ServerRequest serverRequest){
        String id= serverRequest.pathVariable(ServiceConstants.ID);

        return serverRequest.bodyToMono(AddressDto.class)
                .flatMap(requestBody -> orderService.updateAddress(id, requestBody)
                            .flatMap(responseBody -> ServerResponse.ok()
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .bodyValue(responseBody))
                        .onErrorResume(error -> orderServiceErrorHandler.orderResponseErrorHandler(error)));

    }

    public Mono<ServerResponse> deleteOrderById(ServerRequest serverRequest){
        String id= serverRequest.pathVariable(ServiceConstants.ID);
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(orderService.deleteOrder(id), Order.class);
    }


}
