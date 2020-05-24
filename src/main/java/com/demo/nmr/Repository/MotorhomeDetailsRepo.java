package com.demo.nmr.Repository;

import com.demo.nmr.Model.Motorhome;
import com.demo.nmr.Model.MotorhomeDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

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
        return null;
    }

    public MotorhomeDetails findMotorhomeDetailsById(int motorhome_detail_id){
        return null;
    }

    public static Boolean deleteMotorhomeDetailsById(int motorhome_detail_id){
        return null;
    }

    public static Motorhome updateMotorhomeDetailsById(int motorhome_detail_id, MotorhomeDetails m){
        return null;
    }
}
