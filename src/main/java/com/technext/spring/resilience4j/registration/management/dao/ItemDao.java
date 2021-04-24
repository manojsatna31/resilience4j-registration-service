package com.technext.spring.resilience4j.registration.management.dao;

import com.technext.spring.resilience4j.registration.management.entity.Item;
import com.technext.spring.resilience4j.registration.management.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemDao {

    @Autowired
    private ItemRepository itemRepository;

    public Item addItem(Item item){
       return itemRepository.save(item);
    }

    public void saveAllItems(List<Item> itemList){
        itemRepository.saveAll(itemList);
    }

    public List<Item> getAllRegisterItems(){
        return itemRepository.getAllRegisterItems();
    }


}
