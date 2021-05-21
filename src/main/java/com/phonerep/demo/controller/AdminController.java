package com.phonerep.demo.controller;

import com.phonerep.demo.repositories.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;

public class AdminController {

    private UserRepository userRepository;


    public AdminController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public String login() {
        // userModel.addAttribute("userModel", userModel);
        return "login";
    }

}
