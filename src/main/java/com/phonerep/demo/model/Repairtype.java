package com.phonerep.demo.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Repairtype {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reptypeid;

    private String repname;

    public Repairtype(int reptypeid, String repname) {
        this.reptypeid = reptypeid;
        this.repname = repname;
    }

    public Repairtype() {
    }

    @OneToMany
    @JoinColumn(name = "repairtypeid")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "pricelistid")
    private Set<Pricelist> pricelist = new HashSet<>();

    public Set<Pricelist> getPricelist() {
        return pricelist;
    }

    public void setPricelist(Set<Pricelist> pricelist) {
        this.pricelist = pricelist;
    }

    public int getReptypeid() {
        return reptypeid;
    }

    public void setReptypeid(int reptypeid) {
        this.reptypeid = reptypeid;
    }

    public String getRepname() {
        return repname;
    }

    public void setRepname(String repname) {
        this.repname = repname;
    }
}
