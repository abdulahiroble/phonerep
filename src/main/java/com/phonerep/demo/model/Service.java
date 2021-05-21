package com.phonerep.demo.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int serviceid;

    private String servicename;

    public Service() {
    }

    public Service(int serviceid, String servicename) {
        this.serviceid = serviceid;
        this.servicename = servicename;
    }

    @OneToMany
    @JoinColumn(name = "serviceid")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "serviceid")
    private Set<Booking> booking = new HashSet<>();


    public int getServiceid() {
        return serviceid;
    }

    public void setServiceid(int serviceid) {
        this.serviceid = serviceid;
    }

    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename;
    }
}
