package com.demo.nmr.Service;

import com.demo.nmr.Model.TermsAndCond;
import com.demo.nmr.Repository.TermsAndCondRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Service Class for Terms and Conditions Class containing:
//Implementation of methods from TermsAndCondRepo Class
//It's Autowired to access the Repository objects

@Service
public class TermsAndCondService {

    //Autowiring of the TermsAndCondRepo Class and creation of termsAndCondRepo object
    @Autowired
    TermsAndCondRepo termsAndCondRepo;

    //implementation and use of Repo class, returning the method
    public List<TermsAndCond> fetchAll(){
        return termsAndCondRepo.fetchAll();
    }

    //implementation and use of Repo class through the object
    //returns repo object method
    public TermsAndCond addTermsAndCond(TermsAndCond t){
        return termsAndCondRepo.addTermsAndCond(t);
    }

    //implementation and use of Repo class, returning the method
    public TermsAndCond findTermsAndCondById(int tc_id){
        return termsAndCondRepo.findTermsAndCondById(tc_id);
    }

    //implementation and use of Repo class, returning the method
    public Boolean deleteTermsAndCond(int tc_id){
        return termsAndCondRepo.deleteTermsAndCond(tc_id);
    }

    //implementation and use of Repo class, returning the method
    public TermsAndCond updateTermsAndCond(int tc_id, TermsAndCond t){
        return termsAndCondRepo.updateTermsAndCond(tc_id, t);
    }
}
