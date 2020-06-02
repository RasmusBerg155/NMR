package com.demo.nmr.Service;


import com.demo.nmr.Model.CustomerContacts;
import com.demo.nmr.Repository.CustomerContactsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

//Service Class for Customer Contacts containing:
//Implementation of methods from CustomerContactsRepo Class
//It's Autowired to access the Repository objects

@Service
public class CustomerContactsService {

    //Autowiring of the CustomerContactsRepo Class and creation of customerContactsRep object
    @Autowired
    CustomerContactsRepo customerContactsRepo;

    public List<CustomerContacts> fetchAll() {
        return customerContactsRepo.fetchAll();
    }


    public CustomerContacts addCustomerContacts(CustomerContacts c) {
        return customerContactsRepo.addCustomerContacts(c);
    }

    public CustomerContacts findCustomerContactById(int contact_id) {
        return customerContactsRepo.findCustomerContactById(contact_id);
    }

    public boolean deleteCustomerContacts(int contact_id) {
        return customerContactsRepo.deleteCustomerContacts(contact_id);
    }

    public CustomerContacts updateCustomerContacts(int contact_id, CustomerContacts c) {
        return customerContactsRepo.updateCustomerContacts(contact_id, c);
    }
}