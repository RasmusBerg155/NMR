package com.demo.nmr.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

/*
Comments for explanation of all classes are implemented in:
Contract, ContractRepo, ContractService, ContractController, HomeController
 */

@Entity
public class Customer {

    @Id
    private int customer_id;
    private String first_name;
    private String last_name;
    private int contact_id;
    private int address_id;


    public Customer() {
    }


    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getContact_id() {
        return contact_id;
    }

    public void setContact_id(int contact_id) {
        this.contact_id = contact_id;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }
}
