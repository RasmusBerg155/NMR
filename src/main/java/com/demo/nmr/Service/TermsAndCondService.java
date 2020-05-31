package com.demo.nmr.Service;

import com.demo.nmr.Model.TermsAndCond;
import com.demo.nmr.Repository.TermsAndCondRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TermsAndCondService {
    @Autowired
    TermsAndCondRepo termsAndCondRepo;

    public List<TermsAndCond> fetchAll(){
        return termsAndCondRepo.fetchAll();
    }

    public TermsAndCond addTermsAndCond(TermsAndCond t){
        return termsAndCondRepo.addTermsAndCond(t);
    }

    public TermsAndCond findTermsAndCondById(int tc_id){
        return termsAndCondRepo.findTermsAndCondById(tc_id);
    }

    public Boolean deleteTermsAndCond(int tc_id){
        return termsAndCondRepo.deleteTermsAndCond(tc_id);
    }

    public TermsAndCond updateTermsAndCond(int tc_id, TermsAndCond t){
        return termsAndCondRepo.updateTermsAndCond(tc_id, t);
    }
}
