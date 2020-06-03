package com.demo.nmr.Service;

import com.demo.nmr.Model.Motorhome;
import com.demo.nmr.Repository.MotorhomeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
---- Made By Alin Cristian Bejinariu, Rasmus Marco Berg ----

Comments for explanation of all classes are implemented in:
Contract, ContractRepo, ContractService, ContractController, HomeController
 */

@Service
public class MotorhomeService {

    @Autowired
    MotorhomeRepo motorhomeRepo;

    public List<Motorhome> fetchAll(){
        return motorhomeRepo.fetchAll();
    }

    public Motorhome addMotorhome(Motorhome m){
        return motorhomeRepo.addMotorhome(m);
    }

    public Motorhome findMotorhomeById(int motorhome_id){
        return motorhomeRepo.findMotorhomeById(motorhome_id);
    }

    public boolean deleteMotorhome(int motorhome_id){
        return motorhomeRepo.deleteMotorhome(motorhome_id);
    }

    public Motorhome updateMotorhome(int motorhome_id, Motorhome m){
        return motorhomeRepo.updateMotorhome(motorhome_id, m);
    }
}
