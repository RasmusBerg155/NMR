package com.demo.nmr.Service;

import com.demo.nmr.Model.Customer;
import com.demo.nmr.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepo customerRepo;

    public List<Customer> fetchAll(){
        return customerRepo.fetchAll();
    }

    public Customer addCustomer(Customer c){
        return customerRepo.addCustomer(c);
    }

    public Customer findCustomerById(int customer_id){
        return customerRepo.findCustomerById(customer_id);
    }

    public Boolean deleteCustomer(int customer_id){
        return CustomerRepo.deleteCustomer(customer_id);
    }

    public Customer updateCustomer(int customer_id, Customer c){
        return CustomerRepo.updateCustomer(customer_id, c);
    }
}

