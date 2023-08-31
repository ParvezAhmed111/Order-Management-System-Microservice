package com.microservice.order.feignclientservice;

import com.microservice.order.constants.ServiceConstants;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = ServiceConstants.DELIVERY_SERVICE, url = "${delivery.base.url}")
@Headers(value = "Content-Type: application/json")
public interface DeliveryService {

    @PostMapping(value = "${delivery.initiate.order.path}", consumes = MediaType.APPLICATION_JSON_VALUE)
    void initiateDeliveryCreation(@PathVariable String orderId);

}
