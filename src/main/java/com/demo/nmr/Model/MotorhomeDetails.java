package com.demo.nmr.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

//Annotation @Entity for spring
@Entity
public class MotorhomeDetails {

    // Annotation @Id to contract_id
    // Parameters
    @Id
    private int motorhome_detail_id;
    private double km;
    private int passengers;
    private String price_per_day;
    private String extra;

    //Default Constructor
    public MotorhomeDetails() {
    }

    //Getters and Setters
    public int getMotorhome_detail_id() {
        return motorhome_detail_id;
    }

    public void setMotorhome_detail_id(int motorhome_detail_id) {
        this.motorhome_detail_id = motorhome_detail_id;
    }

    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public String getPrice_per_day() {
        return price_per_day;
    }

    public void setPrice_per_day(String price_per_day) {
        this.price_per_day = price_per_day;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }
}
