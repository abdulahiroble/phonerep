package com.phonerep.demo.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerid;



    private String firstname;
    private String lastname;
    private String company;
    private String email;
    private String phone;


    public Customer(int customerid, String firstname, String lastname, String company, String email, String phone) {
        this.customerid = customerid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.company = company;
        this.email = email;
        this.phone = phone;
    }

    public Customer() {
    }

    @OneToMany
    @JoinColumn(name = "customerid")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "customerid")
    private Set<Booking> booking = new HashSet<>();


    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}
