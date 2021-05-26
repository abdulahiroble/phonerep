package com.phonerep.demo.controller;

import com.phonerep.demo.model.Device;
import com.phonerep.demo.model.Shop;
import com.phonerep.demo.repositories.ShopRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(value = "*")
public class ShopRestController {

    ShopRepository shopRepository;

    public ShopRestController(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    @GetMapping("/shops")
    public List<Shop> findAllShops() {
        return shopRepository.findAll();
    }

}
