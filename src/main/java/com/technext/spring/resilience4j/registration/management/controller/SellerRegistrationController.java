package com.technext.spring.resilience4j.registration.management.controller;


import com.technext.spring.resilience4j.registration.management.entity.Seller;
import com.technext.spring.resilience4j.registration.management.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SellerRegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/register/seller")
    public String registerAsSeller(@RequestBody Seller seller) {
        return registrationService.addSeller(seller);
    }
    @GetMapping("/register/sellerList")
    public List<Seller> getSellersList() {
        return registrationService.getAllRegisterSellers();
    }

}
