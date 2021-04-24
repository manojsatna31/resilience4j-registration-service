package com.technext.spring.resilience4j.registration.management.dao;

import com.technext.spring.resilience4j.registration.management.entity.Seller;
import com.technext.spring.resilience4j.registration.management.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerDao {
    @Autowired
    private SellerRepository sellerRepository;

    public Seller addSeller(Seller seller) {
        return sellerRepository.save(seller);
    }
    public List<Seller> getAllRegisterSellers(){
        return sellerRepository.getAllRegisterSellers();
    }

    public void saveAllItem(List<Seller> sellerList) {
        sellerRepository.saveAll(sellerList);
    }


}
