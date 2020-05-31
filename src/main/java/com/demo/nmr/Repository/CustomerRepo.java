package com.demo.nmr.Repository;


import com.demo.nmr.Model.Customer;
import com.demo.nmr.Model.Motorhome;
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

    public Customer addCustomer(Customer c){
        String sql = "INSERT INTO customers (customer_id, first_name ,last_name, contact_id, address_id) VALUES (?, ?, ?, ?, ?);";
        template.update(sql, c.getCustomer_id(), c.getFirst_name(), c.getLast_name(), c.getContact_id(), c.getAddress_id());
        return null;
    }

    public Customer findCustomerById(int customer_id){
        String sql = "SELECT * FROM customers WHERE customer_id = ?";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        Customer c = template.queryForObject(sql, rowMapper, customer_id);
        return c;
    }

    public boolean deleteCustomer(int customer_id){
        String sql ="DELETE FROM customers WHERE customer_id = ?";
        return template.update(sql, customer_id) < 0;
    }

    public Customer updateCustomer(int customer_id, Customer c){
        String sql ="UPDATE customers SET customer_id = ?, first_name = ?, last_name = ?, contact_id = ?, address_id = ? WHERE cusotmer_id = ?";
        template.update(sql, c.getCustomer_id(), c.getFirst_name(), c.getLast_name(), c.getContact_id(), c.getAddress_id());
        return null;
    }
}
