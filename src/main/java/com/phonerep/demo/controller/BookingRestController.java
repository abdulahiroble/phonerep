package com.phonerep.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import com.phonerep.demo.model.Booking;
import com.phonerep.demo.model.Brand;
import com.phonerep.demo.model.Service;
import com.phonerep.demo.model.Shop;
import com.phonerep.demo.repositories.BookingRepository;
import com.phonerep.demo.repositories.BrandRepository;
import com.phonerep.demo.repositories.ServiceRepsitory;
import com.phonerep.demo.repositories.ShopRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(value = "*")
public class BookingRestController {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    ServiceRepsitory serviceRepsitory;

    @Autowired
    ShopRepository shopRepository;

    @Autowired
    BrandRepository brandRepository;

    // @PostMapping(value = "/newbookingjs", consumes = "application/json")
    // @ResponseStatus(HttpStatus.CREATED)
    // public Booking newbookingjs(@RequestBody Booking booking, Model model) {

    // // Service servicex = booking.getService();

    // // int y = Integer.parseInt(servicex.getServicename());

    // // servicex.setServiceid(y);

    // // Shop shopx = booking.getShop();

    // // int x = Integer.parseInt(shopx.getShopname());

    // // shopx.setShopid(x);

    // return bookingRepository.save(booking);
    // }

    @GetMapping("/bookings")
    public List<Booking> findAllServices() {
        return bookingRepository.findAll();
    }

    @PostMapping("/newbookingjs")
    @ResponseStatus(HttpStatus.CREATED)
    public Booking newbooking(@ModelAttribute("booking") Booking booking) {

        // Service servicex = booking.getService();

        // int y = Integer.parseInt(servicex.getServicename());

        // servicex.setServiceid(y);

        // Shop shopx = booking.getShop();

        // int x = Integer.parseInt(shopx.getShopname());

        // shopx.setShopid(x);

        System.out.println(booking);
        return bookingRepository.save(booking);
    }

    @PostMapping("/brand")
    @ResponseStatus(HttpStatus.CREATED)
    public Brand newbrand(@ModelAttribute("brand") Brand brand) {

        System.out.println(brand);
        return brandRepository.save(brand);
    }

    // @PostMapping(value = "/brand", consumes =
    // "application/x-www-form-urlencoded")
    // @ResponseStatus(HttpStatus.CREATED)
    // public Brand brand(@ModelAttribute("brand") Brand brand) {

    // return brandRepository.save(brand);
    // }

}
