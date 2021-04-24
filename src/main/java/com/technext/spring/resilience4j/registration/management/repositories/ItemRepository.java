package com.technext.spring.resilience4j.registration.management.repositories;


import com.arangodb.springframework.annotation.Query;
import com.arangodb.springframework.repository.ArangoRepository;
import com.technext.spring.resilience4j.registration.management.entity.Item;

import java.util.List;

public interface ItemRepository extends ArangoRepository<Item, String> {

    @Query("FOR items IN Item RETURN items")
    List<Item> getAllRegisterItems();
}
