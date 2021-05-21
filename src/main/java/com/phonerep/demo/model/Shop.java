package com.phonerep.demo.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int shopid;

    private String shopname;
    private String address;
    private int postal;
    private String city;
    private Time time;

    public Shop(int shopid, String shopname, String address, int postal, String city, Time time) {
        this.shopid = shopid;
        this.shopname = shopname;
        this.address = address;
        this.postal = postal;
        this.city = city;
        this.time = time;
    }

    public Shop() {
    }

    @OneToMany
    @JoinColumn(name = "shopid")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "bookingid")
    private Set<Booking> booking = new HashSet<>();


    public int getShopid() {
        return shopid;
    }

    public void setShopid(int shopid) {
        this.shopid = shopid;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPostal() {
        return postal;
    }

    public void setPostal(int postal) {
        this.postal = postal;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
