package com.demo.nmr.Service;

import com.demo.nmr.Model.Contract;
import com.demo.nmr.Repository.ContractRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Service Class for Contracts containing:
//Implementation of methods from Contracts Repo Class
//It's Autowired to access the Repository objects

@Service
public class ContractService {
    //Autowiring of the ContractRepo Class and creation of contractRepo object
    @Autowired
    ContractRepo contractRepo;

    public List<Contract> fetchAll(){
        return contractRepo.fetchAll();
    }

    public Contract addContract(Contract co){
        return contractRepo.addContract(co);
    }

    public Contract findContractByID(int contract_id){
        return contractRepo.findContractById(contract_id);
    }

    public boolean deleteContract(int contract_id){
        return contractRepo.deleteContract(contract_id);
    }

    public Contract updateContract(int contract_id, Contract co){
        return contractRepo.updateContract(contract_id, co);
    }
}


