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
        String sql = "SELECT * FROM `pick_up_and_drop_off`;";
        RowMapper<PickUpDropOff> rowMapper = new BeanPropertyRowMapper<>(PickUpDropOff.class);
        return template.query(sql, rowMapper);
    }

    public PickUpDropOff addPickUpDropOff(PickUpDropOff p){
        String sql = "INSERT INTO `pick_up_and_drop_off`(pd_id, pick_up_location, pick_up_distance," +
                "drop_off_location, drop_off_distance) VALUES (?, ?, ?, ?, ?)";
        template.update(sql, p.getPd_id(), p.getPick_up_location(), p.getPick_up_distance(),
                p.getDrop_off_location(), p.getDrop_off_distance());
        return null;
    }

    public PickUpDropOff findPickUpDropOffById(int pd_id){
        String sql = "SELECT * FROM `pick_up_and_drop_off` WHERE pd_id = ?";
        RowMapper<PickUpDropOff> rowMapper = new BeanPropertyRowMapper<>(PickUpDropOff.class);
        PickUpDropOff p = template.queryForObject(sql, rowMapper, pd_id);
        return p;
    }

    public Boolean deletePickUpDropOff(int pd_id){
        String sql ="DELETE FROM `pick_up_and_drop_off` WHERE pd_id = ?";
        return template.update(sql, pd_id) < 0;
    }

    public static PickUpDropOff updatePickUpDropOff(int pd_id, PickUpDropOffRepo p){
        return null;
    }
}
