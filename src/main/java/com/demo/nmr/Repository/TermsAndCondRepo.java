package com.demo.nmr.Repository;

import com.demo.nmr.Model.TermsAndCond;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TermsAndCondRepo {
    @Autowired
    JdbcTemplate template;

    public List<TermsAndCond> fetchAll(){
        String sql = "SELECT * FROM terms_and_conditions;";
        RowMapper<TermsAndCond> rowMapper = new BeanPropertyRowMapper<>(TermsAndCond.class);
        return template.query(sql, rowMapper);
    }

    public TermsAndCond addTermsAndCond(TermsAndCond t){
        String sql = "INSERT INTO terms_and_conditions(tc_id, season, rent_days, km, fuel_tank," +
                "cancellation, notes) VALUES (?, ?, ?, ?, ?, ?, ?)";
        template.update(sql, t.getTc_id(), t.getSeason(), t.getRent_days(), t.getKm(), t.getFuel_tank(),
                t.getCancellation(), t.getNotes());
        return null;
    }

    public TermsAndCond findTermsAndCondById(int tc_id){
        String sql = "SELECT * FROM terms_and_conditions WHERE tc_id = ?";
        RowMapper<TermsAndCond> rowMapper = new BeanPropertyRowMapper<>(TermsAndCond.class);
        TermsAndCond t = template.queryForObject(sql, rowMapper, tc_id);
        return t;
    }

    public boolean deleteTermsAndCond(int tc_id){
        String sql = "DELETE FROM terms_and_conditions WHERE tc_id = ?";
        return template.update(sql, tc_id) < 0;
    }

    public TermsAndCond updateTermsAndCond(int tc_id, TermsAndCond t){
        String sql ="UPDATE terms_and_conditions SET tc_id = ?, season = ?, rent_days = ?, km = ?," +
                "fuel_tank = ?, cancellation = ?, notes = ? WHERE tc_id = ?";
        template.update(sql, t.getTc_id(), t.getSeason(), t.getRent_days(), t.getKm(),
                t.getFuel_tank(), t.getCancellation(), t.getNotes(), t.getTc_id());
        return null;
    }
}
