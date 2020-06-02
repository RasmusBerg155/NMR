package com.demo.nmr.Service;


import com.demo.nmr.Model.CustomerAddresses;
import com.demo.nmr.Model.MotorhomeDetails;
import com.demo.nmr.Repository.CustomerAddressesRepo;
import com.demo.nmr.Repository.MotorhomeDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Service Class for Customer Addresses containing:
//Implementation of methods from CustomerAdressesRepo Class
//It's Autowired to access the Repository objects

@Service
public class CustomerAddressesService {
    @Autowired
    //Autowiring of the CustomerAddressesRepo Class and creation of customerAddressesRepo object
    CustomerAddressesRepo customerAddressesRepo;

    public List<CustomerAddresses> fetchAll() {
        return customerAddressesRepo.fetchAll();
    }


    public CustomerAddresses addCustomerAddresses(CustomerAddresses c) {
        return customerAddressesRepo.addCustomerAddresses(c);
    }

    public CustomerAddresses findCustomerAddressesById(int address_id) {
        return customerAddressesRepo.findCustomerAddressesById(address_id);
    }

    public boolean deleteCustomerAddresses(int address_id) {
        return customerAddressesRepo.deleteCustomerAddresses(address_id);
    }

    public CustomerAddresses updateCustomerAddresses(int address_id, CustomerAddresses c) {
        return customerAddressesRepo.updateCustomerAddresses(address_id, c);
    }

}
