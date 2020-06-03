package com.demo.nmr.Service;

/*
Imports of the Model and Repository classes
Imports for spring framework
Import for List - java.util.list
*/
import com.demo.nmr.Model.Contract;
import com.demo.nmr.Repository.ContractRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/*
----Made By Lara Čulič, Rasmus Berg ----

Service Class for Contracts containing:
Implementation of methods from Contracts Repo Class
It's Autowired to access the Repository objects
*/

@Service
public class ContractService {
    //Autowiring of the ContractRepo Class and creation of contractRepo object
    @Autowired
    ContractRepo contractRepo;

    //Service method returning the contractRepo function
    public List<Contract> fetchAll(){
        return contractRepo.fetchAll();
    }

    //Service method returning the contractRepo function
    public Contract addContract(Contract co){
        return contractRepo.addContract(co);
    }

    //Service method returning the contractRepo function
    public Contract findContractByID(int contract_id){
        return contractRepo.findContractById(contract_id);
    }

    //Service method returning the contractRepo function
    public boolean deleteContract(int contract_id){
        return contractRepo.deleteContract(contract_id);
    }

    //Service method returning the contractRepo function
    public Contract updateContract(int contract_id, Contract co){
        return contractRepo.updateContract(contract_id, co);
    }
}


