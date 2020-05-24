package com.demo.nmr.Repository;

import com.demo.nmr.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepo {
    @Autowired
    JdbcTemplate template;

    public List<Customer> fetchAll(){
        String sql = "SELECT * FROM customers;";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        return template.query(sql, rowMapper);
    }

    public Customer addCustomer(Customer m){
        return null;
    }

    public Customer findCustomerById(int customer_id){
        return null;
    }

    public static Boolean deleteCustomer(int customer_id){
        return null;
    }

    public static Customer updateCustomer(int customer_id, Customer m){
        return null;
    }
}
