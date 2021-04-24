package com.technext.spring.resilience4j.registration.management.service;

import com.technext.spring.resilience4j.registration.management.dao.ItemDao;
import com.technext.spring.resilience4j.registration.management.dao.SellerDao;
import com.technext.spring.resilience4j.registration.management.entity.Item;
import com.technext.spring.resilience4j.registration.management.entity.Seller;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RegistrationService {

    @Autowired
    private ItemDao itemDao;

    @Autowired
    private SellerDao sellerDao;


    public String addSeller(Seller sellerToSave) {

        if (sellerToSave.getEmailId() == null || sellerToSave.getEmailId().isEmpty()) {
            log.error("email id which is mandatory field is null/empty");
            throw new RuntimeException("Seller mail id is not valid. Please enter valid Id");
        }
        try {
            Seller sellerAfterSave = sellerDao.addSeller(sellerToSave);
            log.info("Registration successful. Your registration id is - {} Save it for future communication with us.", sellerAfterSave.getId());
        } catch (Exception ex) {
            log.info("There was some problem in registering the sellerToSave. Please try after some time!!");
            log.info("Exception:{}", ex);

        }
        return "Seller successful saved..";
    }

    public List<Seller> getAllRegisterSellers() {
        return sellerDao.getAllRegisterSellers();
    }

    public String addItem(Item itemToSave) {

        if (isValidItem(itemToSave)) {

            try {
                Item itemAfterSave = itemDao.addItem(itemToSave);
                log.info("Registration successful. Your registration id is - {} Save it for future communication with us.", itemAfterSave.getId());
            } catch (Exception ex) {
                log.info("There was some problem in registering the sellerToSave. Please try after some time!!");
                log.info("Exception:{}", ex);

            }
        } else {
            log.error("All fields is mandatory & can't be empty");
            throw new RuntimeException("Item Validation fails:All fields is mandatory & can't be empty. Please all mandatory fields ");
        }
        return "Item successful saved..";
    }

    public List<Item> getAllRegisterItems() {
        return itemDao.getAllRegisterItems();
    }

    private boolean isValidItem(Item item) {
        log.info("{}",item);
        return !StringUtils.isBlank(item.getName())
                || !StringUtils.isBlank(item.getCategory())
                || item.getPrice() != 0.0;

    }
}
