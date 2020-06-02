package com.demo.nmr.Controller;
/*
Imports of the Model and Service classes
Imports for spring framework
Import for List - java.util.list
*/
import com.demo.nmr.Model.Contract;
import com.demo.nmr.Service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/*
Controller class for Contracts
@Controller annotation for Spring
*/
@Controller
public class ContractController {

    /*@
    Autowired ContractService and creation of the object
     */
    @Autowired
    ContractService contractService;

    /*
    @Getmapping annotation for Spring
    Method for showing contracts:
    - Creation of model-object
    - Creating list containing Contract object
    - Usage of the created contractService-object to fetchAll
    - Mapping the model through addAttribute, named contracts, mapped with contractList
    - Returns contract html page containing thymeleaf to show contracts
     */
    @GetMapping("/ShowContracts")
    public String showContracts(Model model){
        List<Contract> contractList = contractService.fetchAll();
        model.addAttribute("contracts", contractList);
        return "home/contracts/contract";
    }

    /*

     */
    @GetMapping("/createContract")
    public String createContract(){
        return "home/contracts/create_contract";
    }

    @PostMapping("/createContract")
    public String createContract(@ModelAttribute Contract contract){
        contractService.addContract(contract);
        return "redirect:/";
    }

    @GetMapping("/viewContract/{contract_id}")
    public String viewCustomer(@PathVariable("contract_id")int contract_id, Model model){
        model.addAttribute("contracts", contractService.findContractByID(contract_id));
        return "home/contracts/view_contract";
    }

    @GetMapping("/deleteContract/{contract_id}")
    public String deleteContract(@PathVariable("contract_id")int contract_id) {
        boolean delete = contractService.deleteContract(contract_id);
        if(delete) {
            return "redirect:/";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/updateContract/{contract_id}")
    public String updateContract(@PathVariable("contract_id")int contract_id, Model model){
        model.addAttribute("contracts", contractService.findContractByID(contract_id));
        return "home/contracts/update_contract";
    }

    @PostMapping("/updateContract")
    public String updateContract(@ModelAttribute Contract contract){
        contractService.updateContract(contract.getContract_id(), contract);
        return "redirect:/";
    }
}