package com.phonerep.demo.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Pricelist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pricelistid;

    private int repprice;
    private String reptime;

    public Pricelist(int pricelistid, int repprice, String reptime) {
        this.pricelistid = pricelistid;
        this.repprice = repprice;
        this.reptime = reptime;
    }

    public Pricelist() {

    }

    public Pricelist(int pricelistid, int repprice, String reptime, Set<Booking> booking) {
        this.pricelistid = pricelistid;
        this.repprice = repprice;
        this.reptime = reptime;
        this.booking = booking;
    }

    @OneToMany
    @JoinColumn(name = "pricelistid")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "bookingid")
    private Set<Booking> booking = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "repairtypeid")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "repairtypeid")
    private Repairtype repairtype;

    public Repairtype getRepairtype() {
        return repairtype;
    }

    public void setRepairtype(Repairtype repairtype) {
        this.repairtype = repairtype;
    }

    public Set<Booking> getBooking() {
        return booking;
    }

    public void setBooking(Set<Booking> booking) {
        this.booking = booking;
    }

    public int getPricelistid() {
        return pricelistid;
    }

    public void setPricelistid(int pricelistid) {
        this.pricelistid = pricelistid;
    }

    public int getRepprice() {
        return repprice;
    }

    public void setRepprice(int repprice) {
        this.repprice = repprice;
    }

    public String getReptime() {
        return reptime;
    }

    public void setReptime(String reptime) {
        this.reptime = reptime;
    }
}
