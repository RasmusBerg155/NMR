package com.demo.nmr.Controller;

import com.demo.nmr.Model.Contract;
import com.demo.nmr.Model.Customer;
import com.demo.nmr.Service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public class ContractController {
    @Autowired
    ContractService contractService;

    @GetMapping("/ShowContract")
    public String showContract(Model model){
        List<Contract> contractList = contractService.fetchAll();
        model.addAttribute("contract", contractService);
        return "home/contracts";
    }

    @GetMapping("/createContract")
    public String createContract(){
        return "home/contract/create_contract";
    }
    @PostMapping("/createCustomer")
    public String createCustomer(@ModelAttribute Contract contract){
        contractService.addContract(contract);
        return "redirect:/";
    }

    @GetMapping("/viewContract/{contract_id}")
    public String viewCustomer(@PathVariable("contract_id")int contract_id, Model model){
        model.addAttribute("contract", contractService.findContractByID(contract_id));
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
        model.addAttribute("contract", contractService.findContractByID(contract_id));
        return "home/contracts/update_contract";
    }
    @PostMapping("/updateContract")
    public String updateContract(@ModelAttribute Contract contract){
        contractService.updateContract(contract.getContract_id(), contract);
        return "redirect:/";
    }
}

