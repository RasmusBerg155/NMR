package com.demo.nmr.Model;

/*
Imports of javax for Entity and Id
 */
import javax.persistence.Entity;
import javax.persistence.Id;

/*
----Made By Lara Čulič, Rasmus Berg ----

Annotation @Entity for spring
 */

@Entity
public class Contract {

    /*
    Annotation @Id to contract_id
    Parameters
    */
    @Id
    private int contract_id;
    private int pd_id;
    private int tc_id;
    private int motorhome_id;
    private int customer_id;

    //Default Constructor
    public int getContract_id() {
        return contract_id;
    }

    //Getters and Setters
    public void setContract_id(int contract_id) {
        this.contract_id = contract_id;
    }

    public int getPd_id() {
        return pd_id;
    }

    public void setPd_id(int pd_id) {
        this.pd_id = pd_id;
    }

    public int getTc_id() {
        return tc_id;
    }

    public void setTc_id(int tc_id) {
        this.tc_id = tc_id;
    }

    public int getMotorhome_id() {
        return motorhome_id;
    }

    public void setMotorhome_id(int motorhome_id) {
        this.motorhome_id = motorhome_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }
}