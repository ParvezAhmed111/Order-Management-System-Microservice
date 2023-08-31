package com.microservices.inventory.controller;

import com.microservices.inventory.dto.ItemsDTO;
import com.microservices.inventory.entity.Items;
import com.microservices.inventory.service.ItemServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/v1/inventory")
public class itemController {

    @Autowired
    ItemServices itemServices;

    @GetMapping("/availability/{itemId}")
    public String checkAvailability(@PathVariable String itemId, @RequestParam int quantityRequired) {
        return itemServices.itemAvailability(itemId,quantityRequired);
    }

    @GetMapping("/items")
    public List<Items> getAllItems(){
        return itemServices.getItems();
    }

    @GetMapping("/items/{itemId}")
    public Optional<Items> getItemById(@PathVariable String itemId){
        return itemServices.getItemById(itemId);
    }
    @PostMapping("/items")
    public Items addItems(@RequestBody ItemsDTO items){
        return itemServices.addItems(items);
    }
}
