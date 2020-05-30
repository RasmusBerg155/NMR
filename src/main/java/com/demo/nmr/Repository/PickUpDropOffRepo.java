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

    public PickUpDropOff addPickUpDropOff(PickUpDropOff p){
        String sql = "INSERT INTO `pick-up_and_drop-off`(pd_id, pick_up_location, pick_up_distance," +
                "drop_off_location, drop_off_distance) VALUES (?, ?, ?, ?, ?)";
        template.update(sql, p.getPd_id(), p.getPick_up_location(), p.getPick_up_distance(),
                p.getDrop_off_location(), p.getDrop_off_distance());
        return null;
    }

    public PickUpDropOff findPickUpDropOffById(int pd_id){
        String sql = "SELECT * FROM `pick-up_and_drop-off` WHERE pd_id = ?";
        RowMapper<PickUpDropOff> rowMapper = new BeanPropertyRowMapper<>(PickUpDropOff.class);
        PickUpDropOff p = template.queryForObject(sql, rowMapper, pd_id);
        return p;
    }

    public static Boolean deletePickUpDropOff(int pd_id){
        return null;
    }

    public static PickUpDropOff updatePickUpDropOff(int pd_id, PickUpDropOffRepo p){
        return null;
    }
}
