package com.demo.nmr.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

/*
----Made By Lara Čulič ----

Comments for explanation of all classes are implemented in:
Contract, ContractRepo, ContractService, ContractController, HomeController
 */

@Entity
public class CustomerAddresses {


    @Id
    private int address_id;
    private String street_name;
    private int street_no;
    private String city;
    private String country;
    private int zip;


    public CustomerAddresses() {
    }


    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public String getStreet_name() {
        return street_name;
    }

    public void setStreet_name(String street_name) {
        this.street_name = street_name;
    }

    public int getStreet_no() {
        return street_no;
    }

    public void setStreet_no(int street_no) {
        this.street_no = street_no;
    }

    public String getCity() {

        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }
}
