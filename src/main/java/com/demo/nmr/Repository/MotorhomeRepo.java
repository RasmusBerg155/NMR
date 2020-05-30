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
        String sql = "INSERT INTO motorhomes(motorhome_id, brand, model, motorhome_detail_id) VALUES (?, ?, ?, ?)";
        template.update(sql, m.getMotorhome_id(), m.getBrand(), m.getModel(), m.getMotorhome_detail_id());
        return null;
    }

    public Motorhome findMotorhomeById(int motorhome_id){
        String sql = "SELECT * FROM motorhomes WHERE motorhome_id = ?";
        RowMapper<Motorhome> rowMapper = new BeanPropertyRowMapper<>(Motorhome.class);
        Motorhome m = template.queryForObject(sql, rowMapper, motorhome_id);
        return m;
    }


    public Boolean deleteMotorhome(int motorhome_id){
        String sql ="DELETE * FROM motorhomes WHERE motorhome_id = ?";
        return template.update(sql,motorhome_id) < 0;
    }

    public  Motorhome updateMotorhome(int motorhome_id, Motorhome m){
        String sql ="UPDATE motorhome SET brand = ?, model = ? WHERE motorhome_id = ?";
        template.update(sql,m.getBrand(), m.getModel());
        return null;
    }
}
