package com.demo.nmr.Repository;

import com.demo.nmr.Model.MotorhomeDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
---- Made By Alexandru Gabriel Panait ----

Comments for explanation of all classes are implemented in:
Contract, ContractRepo, ContractService, ContractController, HomeController
 */

@Repository
public class MotorhomeDetailsRepo {
    @Autowired
    JdbcTemplate template;

    public List<MotorhomeDetails> fetchAll(){
        String sql = "SELECT * FROM motorhome_details;";
        RowMapper<MotorhomeDetails> rowMapper = new BeanPropertyRowMapper<>(MotorhomeDetails.class);
        return template.query(sql, rowMapper);
    }

    public MotorhomeDetails addMotorhomeDetails(MotorhomeDetails m){
        String sql = "INSERT INTO motorhome_details (motorhome_detail_id, km, passengers, price_per_day, extra) VALUES (?, ?, ?, ?, ?)";
        template.update(sql, m.getMotorhome_detail_id(), m.getKm(), m.getPassengers(), m.getPrice_per_day(), m.getExtra());
        return null;
    }

    public MotorhomeDetails findMotorhomeDetailsById(int motorhome_detail_id){
        String sql = "SELECT * FROM motorhome_details WHERE motorhome_detail_id = ?";
        RowMapper<MotorhomeDetails> rowMapper = new BeanPropertyRowMapper<>(MotorhomeDetails.class);
        MotorhomeDetails m = template.queryForObject(sql, rowMapper, motorhome_detail_id);
        return m;
    }

    public boolean deleteMotorhomeDetailsById(int motorhome_detail_id){
        String sql = "DELETE FROM motorhome_details WHERE motorhome_detail_id = ?";
        return template.update(sql, motorhome_detail_id) < 0;
    }

    public MotorhomeDetails updateMotorhomeDetailsById(int motorhome_detail_id, MotorhomeDetails m){
        String sql = "UPDATE motorhome_details SET motorhome_detail_id = ?, km = ?, passengers = ?, price_per_day = ?, extra = ? WHERE motorhome_detail_id = ?";
        template.update(sql, m.getMotorhome_detail_id(), m.getKm(), m.getPassengers(), m.getPrice_per_day(), m.getExtra(), m.getMotorhome_detail_id());
        return null;
    }
}
