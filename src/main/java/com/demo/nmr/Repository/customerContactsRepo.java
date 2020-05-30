package com.demo.nmr.Repository;
/* import com.demo.nmr.Model.customerContacts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class customerContactsRepo {
    @Autowired
    JdbcTemplate template;

    public List<customerContacts> fetchAll(){
        String sql = "SELECT * FROM `nordic-motorhome`.`customer_contacts`;";
        RowMapper<customerContacts> rowMapper = new BeanPropertyRowMapper<>(customerContacts.class);
        return template.query(sql, rowMapper);
    }
    public customerContacts addcustomerContacts(customerContacts C){
        String sql = "INSERT INTO `nordic-motorhome`.`customer_contacts` (contact_id, e_mail, phone) VALUES (?, ?, ?);";
        template.update(sql, C.getContact_id(), C.getE_mail(), C.getPhone());
        return null;
    }
    public customerContacts findCustomerContactById(int contact_id){
        String sql = "SELECT * FROM `nordic-motorhome`.`customer_contacts` WHERE `contact_id` = ?;";
        RowMapper<customerContacts> rowMapper = new BeanPropertyRowMapper<>(customerContacts.class);
        customerContacts C = template.queryForObject(sql, rowMapper, contact_id);
        return C;
    }
    public Boolean deleteCustomerContacts (int id){
        String sql = "DELETE FROM `nordic-motorhome`.`customer_contacts` WHERE `contact_id` = ?;";
        return template.update(sql, id) < 0;
    }
    public customerContacts updateCustomerContacts(int id, customerContacts C){
        String sql = "UPDATE `nordic-motorhome`.`customer_contacts` SET `e_mail` = ?, `phone` = ? WHERE `contact_id` = ?;";
        template.update(sql, C.getE_mail(), C.getPhone(), C.getContact_id());
        return  null;
    }

}   */
