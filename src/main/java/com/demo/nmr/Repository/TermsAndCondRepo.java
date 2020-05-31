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
        return null;
    }

    public TermsAndCond findTermsAndCondById(int tc_id){
        return null;
    }

    public Boolean deleteTermsAndCond(int tc_id){
        return null;
    }
    public TermsAndCond updateTermsAndCond(int tc_id, TermsAndCond t){
        return null;
    }
}
