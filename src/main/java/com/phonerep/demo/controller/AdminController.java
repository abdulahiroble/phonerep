package com.phonerep.demo.controller;

import com.phonerep.demo.repositories.DeviceRepository;
import com.phonerep.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

public class AdminController {

    private UserRepository userRepository;


    public AdminController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    private DeviceRepository deviceRepository;



    @GetMapping("/login")
    public String login() {
        // userModel.addAttribute("userModel", userModel);
        return "login";
    }


}
