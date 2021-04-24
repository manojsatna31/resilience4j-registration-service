package com.technext.spring.resilience4j.registration.management.controller;


import com.technext.spring.resilience4j.registration.management.entity.Seller;
import com.technext.spring.resilience4j.registration.management.service.RegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
//@CrossOrigin
public class SellerRegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/register/seller")
    public String registerAsSeller(@RequestBody Seller seller) {
        log.info("Inside ItemRegistrationController.registerAsSeller()");
        return registrationService.addSeller(seller);
    }
    @GetMapping("/register/sellerList")
    public List<Seller> getSellersList() {
        log.info("Inside ItemRegistrationController.getItemList()");
        return registrationService.getAllRegisterSellers();
    }

}
