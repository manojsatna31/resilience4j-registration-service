package com.technext.spring.resilience4j.registration.management.controller;

import com.technext.spring.resilience4j.registration.management.entity.Item;
import com.technext.spring.resilience4j.registration.management.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ItemRegistrationController {
    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/register/item")
    public String registerAsItem(@RequestBody Item item) {
        return registrationService.addItem(item);
    }
    @GetMapping("/register/itemList")
    public List<Item> getItemList() {
        return registrationService.getAllRegisterItems();
    }
}
