package com.demo.nmr.Model;

import javax.persistence.*;

@Entity
public class Motorhome {
    @Id
    private int motorhome_id;
    private String brand;
    private String model;
    private int motorhome_detail_id;

    public Motorhome() {
    }

    public int getMotorhome_id() {
        return motorhome_id;
    }

    public void setMotorhome_id(int motorhome_id) {
        this.motorhome_id = motorhome_id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMotorhome_detail_id() {
        return motorhome_detail_id;
    }

    public void setMotorhome_detail_id(int motorhome_detail_id) {
        this.motorhome_detail_id = motorhome_detail_id;
    }
}
