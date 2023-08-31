package com.microservice.order.routers;

import com.microservice.order.constants.ServiceConstants;
import com.microservice.order.handlers.OrderHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class OrderRouter {

    @Bean
    public RouterFunction<ServerResponse> orderAPIs(OrderHandler orderHandler){
        return route(POST("v1/order"), orderHandler :: createOrder )
                .andRoute(GET("v1/orders"), orderHandler :: getAllOrders)
                .andRoute(GET("v1/order/{id}"), orderHandler :: getOrderById)
                .andRoute(PUT("v1/order/{id}"), orderHandler :: updateAddress)
                .andRoute(DELETE("v1/order/{id}"), orderHandler :: deleteOrderById);
    }
}
