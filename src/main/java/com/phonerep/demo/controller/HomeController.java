package com.phonerep.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

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
}

