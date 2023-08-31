package com.microservices.inventory.service;

import com.microservices.inventory.dto.ItemsDTO;
import com.microservices.inventory.entity.Items;
import com.microservices.inventory.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class ItemServices {

    @Autowired
    private ItemRepository itemRepository;

    public static String currDateAsString() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
    }

    public String itemAvailability(String itemId, int quantityRequired){
      Items items = itemRepository.findById(itemId).orElse(null);
      if(items != null)
          return (quantityRequired < items.getQuantityAvailable())? "true" : "false";
      return "null";
    }

    public List<Items> getItems (){
        return itemRepository.findAll();
    }

    public Optional<Items> getItemById(String itemId){
        return itemRepository.findById(itemId);
    }
    public Items addItems(ItemsDTO itemsDTO){
        Items items = new Items();
        items.setItemId(itemsDTO.getItemId());
        items.setItemName(itemsDTO.getItemName());
        items.setCategory(itemsDTO.getCategory());
        items.setPrice(itemsDTO.getPrice());
        items.setDescription(itemsDTO.getDescription());
        items.setSupplier(itemsDTO.getSupplier());
        items.setQuantityAvailable(itemsDTO.getQuantityAvailable());
        items.setDate(currDateAsString());
        return itemRepository.save(items);

    }
}
