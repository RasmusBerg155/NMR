package com.demo.nmr.Service;


import com.demo.nmr.Model.CustomerAddresses;
import com.demo.nmr.Model.MotorhomeDetails;
import com.demo.nmr.Repository.CustomerAddressesRepo;
import com.demo.nmr.Repository.MotorhomeDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
Comments for explanation of all classes are implemented in:
Contract, ContractRepo, ContractService, ContractController, HomeController
 */

@Service
public class CustomerAddressesService {

    @Autowired
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
