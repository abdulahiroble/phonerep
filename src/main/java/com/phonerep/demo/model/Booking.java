package com.phonerep.demo.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingid;

    private Date date;
    private Time time;

    public Booking() {


    }

    public Booking(int bookingid, Date date, Time time) {
        this.bookingid = bookingid;
        this.date = date;
        this.time = time;
    }

    @ManyToOne
    @JoinColumn(name = "shopid")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "shopid")
    private Shop shop;

    @ManyToOne
    @JoinColumn(name = "serviceid")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "serviceid")
    private Service service;

    @ManyToOne
    @JoinColumn(name = "customerid")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "customerid")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "deviceid")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "deviceid")
    private Device device;

    @ManyToOne
    @JoinColumn(name = "pricelistid")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "pricelistid")
    private Pricelist pricelist;

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public Pricelist getPricelist() {
        return pricelist;
    }

    public void setPricelist(Pricelist pricelist) {
        this.pricelist = pricelist;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
