package com.phonerep.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import com.phonerep.demo.model.Booking;
import com.phonerep.demo.model.Brand;
import com.phonerep.demo.model.Customer;
import com.phonerep.demo.model.Pricelist;
import com.phonerep.demo.model.Service;
import com.phonerep.demo.model.Shop;
import com.phonerep.demo.repositories.BookingRepository;
import com.phonerep.demo.repositories.BrandRepository;
import com.phonerep.demo.repositories.CustomerRepository;
import com.phonerep.demo.repositories.PricelistRepository;
import com.phonerep.demo.repositories.ServiceRepsitory;
import com.phonerep.demo.repositories.ShopRepository;
import com.phonerep.demo.service.PriceListService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.phonerep.demo.model.Pricelist;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

    @Autowired
    private PriceListService priceListService;

    @GetMapping("/")
    public String getHomepage() {

        return "index";
    }

    @GetMapping("/user")
    public String user() {
        return "user";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/booking")
    public String booking() {
        return "booking";
    }

    @GetMapping("/kontakt")
    public String kontakt() {
        return "kontakt";
    }

    @GetMapping("erhverv")
    public String erhverv() {
        return "erhverv";
    }

    @GetMapping("butikker")
    public String butikker() {
        return "butikker";
    }

    @GetMapping("updatepricelist")
    public String updatepricelist() {
        return "updatepricelist";
    }

    @GetMapping("bestil-tid")
    public String bestiltid() {
        return "bestil-tid";
    }

    @GetMapping("/seepricelist")
    public String seemovie(Model movie) {

        // movie.addAttribute("movie", new Movie());

        return showMovieList(1, movie);
    }

    @GetMapping("/pricelistUpdate/{pricelistid}")
    public String pricelistUpdate(@PathVariable(value = "pricelistid") int pricelistid, Model model) {

        try {
            Pricelist pricelist = priceListService.getPriceListById(pricelistid);

            model.addAttribute("pricelist", pricelist);

        } catch (Exception e) {
            System.out.println("Error can't update user profile " + e);
        }

        return "updatepricelist";
    }

    @GetMapping("/pricelist/{pricelistNo}")
    public String showMovieList(@PathVariable(value = "pricelistNo") int pageNo, Model model) {

        try {
            int pageSize = 10;

            Page<Pricelist> page = priceListService.showMovieList(pageNo, pageSize);

            List<Pricelist> listMovie = page.getContent();

            model.addAttribute("listMovie", listMovie);

        } catch (Exception e) {
            System.out.println("Error can't load up list " + e);
        }

        return "admin";
    }
}
