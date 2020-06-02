package com.demo.nmr.Model;
import javax.persistence.Entity;
import javax.persistence.Id;

//Annotation @Entity for spring
@Entity
public class CustomerContacts {

    // Annotation @Id to contract_id
    // Parameters
    @Id
    private int contact_id;
    private String e_mail;
    private String phone;

    //Default Constructor
    public CustomerContacts() {
    }

    //Getters and Setters
    public int getContact_id() {
        return contact_id;
    }

    public void setContact_id(int contact_id) {
        this.contact_id = contact_id;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
