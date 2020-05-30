package com.demo.nmr.Service;

import com.demo.nmr.Model.CustomerContacts;
import com.demo.nmr.Repository.CustomerContactsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerContactsService {
    @Autowired
    CustomerContactsRepo customerContactsRepo;

    public List<CustomerContacts> fetchAll(){
        return customerContactsRepo.fetchAll();
    }
    public CustomerContacts addcustomerContacts(CustomerContacts c){
        return customerContactsRepo.addCustomerContacts(c);
    }
    public CustomerContacts findCustomerContactById(int contact_id){
        return customerContactsRepo.findCustomerContactById(contact_id);
    }
    public boolean deleteCustomerContacts (int id){
        return customerContactsRepo.deleteCustomerContacts(id);
    }
    public CustomerContacts updateCustomerContacts(int id, CustomerContacts c){
        return customerContactsRepo.updateCustomerContacts(id, c);
    }
}