package com.demo.nmr.Repository;
import com.demo.nmr.Model.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//Repository Class containing: all sql code for our crud functionality to run on our MySQL Database
//Autowired to database through JdbcTemplate
@Repository
public class ContractRepo {
    @Autowired
    JdbcTemplate template;

    //Method for implementing sql code
    //usage of RowMapper interface to map rows from resultset
    //Usage of template -> perform the query -> use sql statement -> return in rowMapper
    public List<Contract> fetchAll(){
        String sql = "SELECT * FROM contracts;";
        RowMapper<Contract> rowMapper = new BeanPropertyRowMapper<>(Contract.class);
        return template.query(sql, rowMapper);
    }

    //Method for implementing sql code
    //
    public Contract addContract(Contract co){
        String sql = "INSERT INTO contracts (contract_id, pd_id, tc_id, motorhome_id, customer_id) VALUES (?, ?, ?, ?, ?);";
        template.update(sql, co.getContract_id(),co.getPd_id(),co.getTc_id(),co.getMotorhome_id(),co.getCustomer_id());
        return null;
    }

    //Method for implementing sql code
    //usage of RowMapper interface to map rows from resultset
    public Contract findContractById(int contract_id){
        String sql = "SELECT * FROM contracts WHERE contract_id = ?";
        RowMapper<Contract> rowMapper = new BeanPropertyRowMapper<>(Contract.class);
        Contract co = template.queryForObject(sql, rowMapper, contract_id);
        return co;
    }


    public boolean deleteContract(int contract_id){
        String sql ="DELETE FROM contracts WHERE contract_id = ?";
        return template.update(sql, contract_id) < 0;
    }

    public Contract updateContract(int contract_id, Contract co){
        String sql ="UPDATE contracts SET contract_id = ?, pd_id = ?, tc_id = ?, motorhome_id = ?, customer_id WHERE motorhome_id = ?";
        template.update(sql, co.getContract_id(),co.getPd_id(),co.getTc_id(),co.getMotorhome_id(),co.getCustomer_id());
        return null;
    }
}