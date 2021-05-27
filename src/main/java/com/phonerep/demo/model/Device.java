package com.phonerep.demo.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deviceid;

    @Column(name = "model")
    private String model;

    @Column(name = "code")
    private String code;

    public Device(String model) {
        this.model = model;
    }

    public Device() {
    }

    public Device(int deviceid, String model, String code) {
        this.deviceid = deviceid;
        this.model = model;
        this.code = code;
    }

    @ManyToOne
    @JoinColumn(name = "brandid")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "brandid")

    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "pricelistid")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "pricelistid")

    private Pricelist pricelist;

    public Pricelist getPricelist() {
        return pricelist;
    }

    public void setPricelist(Pricelist pricelist) {
        this.pricelist = pricelist;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public int getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(int deviceid) {
        this.deviceid = deviceid;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
