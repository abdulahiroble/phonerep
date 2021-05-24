package com.phonerep.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ReservationController {

    @GetMapping("/bestil")
    public String bestil() {
        return "bestil";
    }
}
