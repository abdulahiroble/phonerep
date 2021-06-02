package com.phonerep.demo.controller;

import com.phonerep.demo.model.Device;
import com.phonerep.demo.model.Pricelist;
import com.phonerep.demo.model.Repairtype;
import com.phonerep.demo.repositories.DeviceRepository;
import com.phonerep.demo.repositories.PricelistRepository;
import com.phonerep.demo.repositories.RepairtypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @Autowired
    PricelistRepository pricelistRepository;

    @GetMapping("/devices")
    public List<Device> findAllDevices() {
        return deviceRepository.findAll();
    }

    @GetMapping("/repairtype")
    public List<Repairtype> findAllRepairtypes() {
        return repairtypeRepository.findAll();
    }

    // @PutMapping("/pricelist/{id}")
    // public void update(@PathVariable int id, @RequestBody Pricelist
    // pricelistinfo) {
    // Pricelist pricelist = new Pricelist();
    // pricelistinfo.setPricelistid(id);
    // pricelistinfo.setRepprice(pricelistinfo.getRepprice());
    // pricelistinfo.setReptime(pricelistinfo.getReptime());
    // pricelistRepository.save(pricelist);
    // }

    // @RequestMapping(value = "/pricelist/{id}", method = RequestMethod.PUT,
    // consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    // Pricelist updatePricelist(@RequestBody Pricelist newEmployee, @PathVariable
    // int id) throws Exception {

    // return pricelistRepository.findById(id).map(employee -> {
    // employee.setPricelistid(newEmployee.getPricelistid());
    // employee.setRepprice(newEmployee.getRepprice());
    // return pricelistRepository.save(employee);
    // }).orElseGet(() -> {
    // newEmployee.setPricelistid(id);
    // return pricelistRepository.save(newEmployee);
    // });
    // }

    // @PutMapping("/pricelist/{pricelistid}")
    // public ResponseEntity<Pricelist> updateEmployee(@PathVariable(value =
    // "pricelistid") int employeeId,
    // @Validated @RequestBody Pricelist employeeDetails) throws
    // ResourceNotFoundException {
    // Pricelist employee = pricelistRepository.findById(employeeId)
    // .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this
    // id :: " + employeeId));

    // employee.setPricelistid(employeeDetails.getPricelistid());
    // employee.setRepprice(employeeDetails.getRepprice());
    // employee.setReptime(employeeDetails.getReptime());
    // final Pricelist updatedEmployee = pricelistRepository.save(employee);
    // return ResponseEntity.ok(updatedEmployee);
    // }

    @PutMapping("/pricelist/{pricelistid}")
    public ResponseEntity<Pricelist> updateUser(@PathVariable(value = "pricelistid") int pricelistid,
            @RequestBody Pricelist userDetails) throws ResourceNotFoundException {
        Pricelist user = pricelistRepository.findById(pricelistid)
                .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + pricelistid));

        user.setPricelistid(userDetails.getPricelistid());
        user.setRepprice(userDetails.getRepprice());
        user.setReptime(userDetails.getReptime());

        final Pricelist updatedUser = pricelistRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }

}