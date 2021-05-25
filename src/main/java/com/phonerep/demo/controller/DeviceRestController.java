package com.phonerep.demo.controller;

import com.phonerep.demo.model.Device;
import com.phonerep.demo.model.Repairtype;
import com.phonerep.demo.repositories.DeviceRepository;
import com.phonerep.demo.repositories.RepairtypeRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(value = "*")
public class DeviceRestController {

    DeviceRepository deviceRepository;
    RepairtypeRepository repairtypeRepository;

    public DeviceRestController(DeviceRepository deviceRepository, RepairtypeRepository repairtypeRepository) {
        this.deviceRepository = deviceRepository;
        this.repairtypeRepository = repairtypeRepository;
    }

    @GetMapping("/devices")
    public List<Device> findAllDevices() {
        return deviceRepository.findAll();
    }

    @GetMapping("/repairtype")
    public List<Repairtype> findAllRepairtypes() {
        return repairtypeRepository.findAll();
    }
}
