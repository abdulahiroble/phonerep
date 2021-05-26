package com.phonerep.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.phonerep.demo.model.Booking;
import com.phonerep.demo.model.Service;
import com.phonerep.demo.model.Shop;
import com.phonerep.demo.repositories.BookingRepository;
import com.phonerep.demo.repositories.ServiceRepsitory;
import com.phonerep.demo.repositories.ShopRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(value = "*")
public class BookingRestController {

    BookingRepository bookingRepository;
    ServiceRepsitory serviceRepsitory;
    ShopRepository shopRepository;

    @PostMapping(value = "/newbookingjs", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Booking newbookingjs(@RequestBody Booking booking, Model model) {

        Service servicex = booking.getService();

        int y = Integer.parseInt(servicex.getServicename());

        servicex.setServiceid(y);

        Shop shopx = booking.getShop();

        int x = Integer.parseInt(shopx.getShopname());

        shopx.setShopid(x);

        return bookingRepository.save(booking);
    }
}
