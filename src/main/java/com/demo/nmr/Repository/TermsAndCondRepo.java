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
                "cancellation, notes) VALUES (?, ?, ?, ?, ?, ?)";
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

    public Boolean deleteTermsAndCond(int tc_id){
        return null;
    }

    public TermsAndCond updateTermsAndCond(int tc_id, TermsAndCond t){
        return null;
    }
}
