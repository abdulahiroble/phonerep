package com.phonerep.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class DevicesController {

    @GetMapping("/iphone5")
    public String iphone5() {

        return "iphone5";
    }

}
