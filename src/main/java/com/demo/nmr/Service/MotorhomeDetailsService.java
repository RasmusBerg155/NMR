package com.demo.nmr.Service;

import com.demo.nmr.Model.Motorhome;
import com.demo.nmr.Model.MotorhomeDetails;
import com.demo.nmr.Repository.MotorhomeDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Service Class for MotorhomeDetails containing:
//Implementation of methods from MotorhomeDetailsRepo Class
//It's Autowired to access the Repository objects

@Service
public class MotorhomeDetailsService {

    //Autowiring of the MotorhomeDetailsRepo Class and creation of motorhomeDetailsRepo object
    @Autowired
    MotorhomeDetailsRepo motorhomeDetailsRepo;

    public List<MotorhomeDetails> fetchAll(){
        return motorhomeDetailsRepo.fetchAll();
    }

    public MotorhomeDetails addMotorhomeDetails(MotorhomeDetails m){
        return motorhomeDetailsRepo.addMotorhomeDetails(m);
    }

    public MotorhomeDetails findMotorhomeDetailsById(int motorhome_detail_id){
        return motorhomeDetailsRepo.findMotorhomeDetailsById(motorhome_detail_id);
    }

    public boolean deleteMotorhomeDetailsById(int motorhome_detail_id){
        return motorhomeDetailsRepo.deleteMotorhomeDetailsById(motorhome_detail_id);
    }

    public MotorhomeDetails updateMotorhomeDetailsById(int motorhome_detail_id, MotorhomeDetails m){
        return motorhomeDetailsRepo.updateMotorhomeDetailsById(motorhome_detail_id, m);
    }
}