package com.demo.nmr.Service;


import com.demo.nmr.Model.CustomerContacts;
import com.demo.nmr.Repository.CustomerContactsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/*
----Made By Lara Čulič ----

Comments for explanation of all classes are implemented in:
Contract, ContractRepo, ContractService, ContractController, HomeController
 */

@Service
public class CustomerContactsService {

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