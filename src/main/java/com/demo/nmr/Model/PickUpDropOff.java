package com.demo.nmr.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

/*
Comments for explanation of all classes are implemented in:
Contract, ContractRepo, ContractService, ContractController, HomeController
 */

@Entity
public class PickUpDropOff {

    @Id
    private int pd_id;
    private String pick_up_location;
    private double pick_up_distance;
    private String drop_off_location;
    private double drop_off_distance;

    public PickUpDropOff() {
    }

    public int getPd_id() {
        return pd_id;
    }

    public void setPd_id(int pd_id) {
        this.pd_id = pd_id;
    }

    public String getPick_up_location() {
        return pick_up_location;
    }

    public void setPick_up_location(String pick_up_location) {
        this.pick_up_location = pick_up_location;
    }

    public double getPick_up_distance() {
        return pick_up_distance;
    }

    public void setPick_up_distance(double pick_up_distance) {
        this.pick_up_distance = pick_up_distance;
    }

    public String getDrop_off_location() {
        return drop_off_location;
    }

    public void setDrop_off_location(String drop_off_location) {
        this.drop_off_location = drop_off_location;
    }

    public double getDrop_off_distance() {
        return drop_off_distance;
    }

    public void setDrop_off_distance(double drop_off_distance) {
        this.drop_off_distance = drop_off_distance;
    }
}
