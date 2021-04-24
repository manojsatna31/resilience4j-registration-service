package com.technext.spring.resilience4j.registration.management.repositories;


import com.arangodb.springframework.annotation.Query;
import com.arangodb.springframework.repository.ArangoRepository;
import com.technext.spring.resilience4j.registration.management.entity.Seller;

import java.util.List;

public interface SellerRepository extends ArangoRepository<Seller, String> {

    @Query("FOR sellers IN Seller RETURN sellers")
    List<Seller> getAllRegisterSellers();
}
