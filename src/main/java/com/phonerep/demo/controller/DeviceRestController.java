package com.phonerep.demo.controller;

import com.phonerep.demo.model.Device;
import com.phonerep.demo.repositories.DeviceRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(value = "*")
public class DeviceRestController {

DeviceRepository deviceRepository;

    public DeviceRestController(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @GetMapping("/devices")
    public List<Device> findAllDevices() {
        return deviceRepository.findAll();
    }
}
