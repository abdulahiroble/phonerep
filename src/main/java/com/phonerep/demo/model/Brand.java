package com.phonerep.demo.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int brandid;

    private String brandname;

    public Brand(int brandid, String brandname) {
        this.brandid = brandid;
        this.brandname = brandname;
    }

    public Brand() {
    }


    @OneToMany
    @JoinColumn(name = "brandid")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "deviceid")
    private Set<Device> device = new HashSet<>();






    public int getBrandid() {
        return brandid;
    }

    public void setBrandid(int brandid) {
        this.brandid = brandid;
    }

    public String getBrandname() {
        return brandname;
    }

    public void setBrandname(String brandname) {
        this.brandname = brandname;
    }
}
