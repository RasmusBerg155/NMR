package com.demo.nmr.Repository;

import com.demo.nmr.Model.CustomerAddresses;
import com.demo.nmr.Model.MotorhomeDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
Comments for explanation of all classes are implemented in:
Contract, ContractRepo, ContractService, ContractController, HomeController
 */

@Repository
public class CustomerAddressesRepo {
    @Autowired
    JdbcTemplate template;

    public List<CustomerAddresses> fetchAll() {
        String sql = "SELECT * FROM customer_addresses;";
        RowMapper<CustomerAddresses> rowMapper = new BeanPropertyRowMapper<>(CustomerAddresses.class);
        return template.query(sql,rowMapper);
    }

    public CustomerAddresses addCustomerAddresses(CustomerAddresses c) {
        String sql = "INSERT INTO customer_addresses (address_id, street_name, street_no, city, country, zip) VALUES (?, ?, ?, ?, ?, ?)";
        template.update(sql, c.getAddress_id(), c.getStreet_name(), c.getStreet_no(), c.getCity(), c.getCountry(), c.getZip());
        return null;
    }


    public CustomerAddresses findCustomerAddressesById(int address_id) {
        String sql = "SELECT * FROM customer_addresses WHERE address_id = ?";
        RowMapper<CustomerAddresses> rowMapper = new BeanPropertyRowMapper<>(CustomerAddresses.class);
        CustomerAddresses c = template.queryForObject(sql, rowMapper, address_id);
        return c;
    }

    public boolean deleteCustomerAddresses(int address_id) {
        String sql = "DELETE FROM customer_addresses WHERE address_id = ?";
        return template.update(sql, address_id) < 0;
    }

    public CustomerAddresses updateCustomerAddresses(int address_id, CustomerAddresses c) {
        String sql = "UPDATE `nordic-motorhome`.`customer_addresses` SET street_name = ?, street_no = ?, city = ?, country = ?, zip = ? WHERE address_id = ?;";
        template.update(sql, c.getStreet_name(), c.getStreet_no(), c.getCity(), c.getCountry(), c.getZip(), c.getAddress_id());
        return null;
    }

}
