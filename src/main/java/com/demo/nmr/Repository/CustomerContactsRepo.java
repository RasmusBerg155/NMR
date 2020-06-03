package com.demo.nmr.Repository;

import com.demo.nmr.Model.CustomerContacts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

/*
----Made By Lara Čulič ----

Comments for explanation of all classes are implemented in:
Contract, ContractRepo, ContractService, ContractController, HomeController
 */

@Repository
public class CustomerContactsRepo {
    @Autowired
    JdbcTemplate template;

    public List<CustomerContacts> fetchAll(){
        String sql = "SELECT * FROM customer_contacts;";
        RowMapper<CustomerContacts> rowMapper = new BeanPropertyRowMapper<>(CustomerContacts.class);
        return template.query(sql, rowMapper);
    }

    public CustomerContacts addCustomerContacts(CustomerContacts c){
        String sql = "INSERT INTO `nordic-motorhome`.`customer_contacts` (contact_id, e_mail, phone) VALUES (?, ?, ?);";
        template.update(sql, c.getContact_id(), c.getE_mail(), c.getPhone());
        return null;
    }
    public CustomerContacts findCustomerContactById(int contact_id){
        String sql = "SELECT * FROM `nordic-motorhome`.`customer_contacts` WHERE `contact_id` = ?;";
        RowMapper<CustomerContacts> rowMapper = new BeanPropertyRowMapper<>(CustomerContacts.class);
        CustomerContacts c = template.queryForObject(sql, rowMapper, contact_id);
        return c;
    }

   public boolean deleteCustomerContacts (int id){
        String sql = "DELETE FROM `nordic-motorhome`.`customer_contacts` WHERE `contact_id` = ?;";
        return template.update(sql, id) < 0;
    }

    public CustomerContacts updateCustomerContacts(int id, CustomerContacts c){
        String sql = "UPDATE `nordic-motorhome`.`customer_contacts` SET `e_mail` = ?, `phone` = ? WHERE `contact_id` = ?;";
        template.update(sql, c.getE_mail(), c.getPhone(), c.getContact_id());
        return  null;
    }

}
