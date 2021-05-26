package com.phonerep.demo.controller;

import com.phonerep.demo.model.Service;
import com.phonerep.demo.model.Shop;
import com.phonerep.demo.repositories.ServiceRepsitory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(value = "*")
public class ServiceRestController {

    ServiceRepsitory serviceRepsitory;

    public ServiceRestController(ServiceRepsitory serviceRepsitory) {
        this.serviceRepsitory = serviceRepsitory;
    }

    @GetMapping("/services")
    public List<Service> findAllServices() {
        return serviceRepsitory.findAll();
    }

}
