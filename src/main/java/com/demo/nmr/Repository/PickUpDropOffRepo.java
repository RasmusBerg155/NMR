package com.demo.nmr.Repository;

import com.demo.nmr.Model.PickUpDropOff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PickUpDropOffRepo {
    @Autowired
    JdbcTemplate template;

    public List<PickUpDropOff> fetchAll(){
        String sql = "SELECT * FROM `pick-up_and_drop-off`;";
        RowMapper<PickUpDropOff> rowMapper = new BeanPropertyRowMapper<>(PickUpDropOff.class);
        return template.query(sql, rowMapper);
    }

    public PickUpDropOff addPickUpDropOff(PickUpDropOffRepo p){
        return null;
    }

    public PickUpDropOff findPickUpDropOffById(int pd_id){
        return null;
    }

    public static Boolean deletePickUpDropOff(int pd_id){
        return null;
    }

    public static PickUpDropOff updatePickUpDropOff(int pd_id, PickUpDropOffRepo p){
        return null;
    }
}
