package com.microservice.order.feignclientservice;

import com.microservice.order.constants.ServiceConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = ServiceConstants.INVENTORY_SERVICE, url = "${inventory.base.url}")
public interface InventoryService {
    @GetMapping(value = "${inventory.availability.path}")
    String checkAvailability(@PathVariable String itemId, @RequestParam int quantityRequired);

}


