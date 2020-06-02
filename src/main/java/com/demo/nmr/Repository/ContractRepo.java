package com.demo.nmr.Repository;
/*
Import for the Model class
Imports for spring framework
Import for List - java.util.list
*/
import com.demo.nmr.Model.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

/*
Repository Class containing: all sql code for our crud functionality to run on our MySQL Database
Autowired to database through JdbcTemplate
*/
@Repository
public class ContractRepo {
    @Autowired
    JdbcTemplate template;

    /*
    Method for fetch All:
    - Creation of string containing the sql code, selecting all from "contracts" table
    - Usage of RowMapper interface to map rows from resultset
    - Usage of template -> perform the query for multiple rows -> use sql statement -> return in rowMapper
    */
    public List<Contract> fetchAll(){
        String sql = "SELECT * FROM contracts;";
        RowMapper<Contract> rowMapper = new BeanPropertyRowMapper<>(Contract.class);
        return template.query(sql, rowMapper);
    }

    /*
    Method for Add Contract:
    - String = "sql code" -> for inserting into contracts table
    - Usage of the template object
    - Usage of updateQuery to fill contracts with the placeholders
    - Returns null
     */
    public Contract addContract(Contract co){
        String sql = "INSERT INTO contracts (contract_id, pd_id, tc_id, motorhome_id, customer_id) VALUES (?, ?, ?, ?, ?);";
        template.update(sql, co.getContract_id(),co.getPd_id(),co.getTc_id(),co.getMotorhome_id(),co.getCustomer_id());
        return null;
    }

    /*
    Method for Find Contract By Id:
    - String = "sql code" -> selecting a table from contracts with the specidfic contract_id
    - Usage of RowMapper interface to map rows from resultset
    - Creation of Contract co object
    - Usage of template -> perform queryForObjects for a single row -> use sql statement ->
    return in rowMapper -> where contract_id
    - Returns co object
     */
    public Contract findContractById(int contract_id){
        String sql = "SELECT * FROM contracts WHERE contract_id = ?";
        RowMapper<Contract> rowMapper = new BeanPropertyRowMapper<>(Contract.class);
        Contract co = template.queryForObject(sql, rowMapper, contract_id);
        return co;
    }

    /*
    Method for Delete Contract:
    - String = "sql code" -> deleting a table from contracts with the specific contract_id
    - Returns template object with updateQuery, containing sql code and contract id
     */
    public boolean deleteContract(int contract_id){
        String sql ="DELETE FROM contracts WHERE contract_id = ?";
        return template.update(sql, contract_id) < 0;
    }

    /*
    Method for Updating Contract:
    - String = "sql code" -> update a table from contracts and setting rows for the specific contract_id
    - Usage of template object
    - Usage of updateQuery to fill contracts with the placeholders
    - Returns null
     */
    public Contract updateContract(int contract_id, Contract co){
        String sql ="UPDATE contracts SET contract_id = ?, pd_id = ?, tc_id = ?, motorhome_id = ?, customer_id WHERE contract_id = ?";
        template.update(sql, co.getContract_id(),co.getPd_id(),co.getTc_id(),co.getMotorhome_id(),co.getCustomer_id());
        return null;
    }
}