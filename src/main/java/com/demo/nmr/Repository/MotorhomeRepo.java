package com.demo.nmr.Repository;

import com.demo.nmr.Model.Motorhome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MotorhomeRepo {
    @Autowired
    JdbcTemplate template;

    public List<Motorhome> fetchAll(){
        String sql = "SELECT * FROM motorhomes;";
        RowMapper<Motorhome> rowMapper = new BeanPropertyRowMapper<>(Motorhome.class);
        return template.query(sql, rowMapper);
    }

    public Motorhome addMotorhome(Motorhome m){
        return null;
    }

    public Motorhome findMotorhomeById(int motorhome_id){
        return null;
    }

    public static Boolean deleteMotorhome(int motorhome_id){
        return null;
    }

    public static Motorhome updateMotorhome(int motorhome_id, Motorhome m){
        return null;
    }
}
