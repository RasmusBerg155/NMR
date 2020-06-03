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
----Made By Lara Čulič, Rasmus Berg ----

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
    Method for showing contracts:
    @Getmapping annotation containing the /ShowContracts path
    - Creation of model-object from Model interface
    - Creating list containing Contract object
    - Usage of the contractService-object to fetchAll
    - Mapping the model through addAttribute, named contracts, mapped with contractList
    - Returns contract html page containing thymeleaf to show contracts
     */
    @GetMapping("/showContracts")
    public String showContracts(Model model){
        List<Contract> contractList = contractService.fetchAll();
        model.addAttribute("contracts", contractList);
        return "home/contracts/contract";
    }

    /*
    Method for showing the create contract:
    @Getmapping annotation containing the /createContract path
    - Returns the html page to create a new contract
     */
    @GetMapping("/createContract")
    public String createContract(){
        return "home/contracts/create_contract";
    }

    /*
    Method for creating contract:
    @PostMapping annotation containing the /createContract path
    - Usage of @ModelAttribute for making model and addAttribute to the created object "contract"
    - Usage of contractService to add Contract into the contract-object
    - Returns a redirection to /ShowContracts to run it again
     */
    @PostMapping("/createContract")
    public String createContract(@ModelAttribute Contract contract){
        contractService.addContract(contract);
        return "redirect:/showContracts";
    }

    /*
    Method for viewing a contract:
    @GetMapping annotation containing the /viewContract path and attachment of {contract_id)
    - The method contains the @pathvariable to get ("contract_id")
    - The method puts it into the variable int contract_id
    - The method creates the model object to display
    - Usage of the addAttribute from model named "contracts"
    - Usage of contractService object to access findContractByID(contract_id)
    - Returns view contract html page
     */
    @GetMapping("/viewContract/{contract_id}")
    public String viewContract(@PathVariable("contract_id")int contract_id, Model model){
        model.addAttribute("contracts", contractService.findContractByID(contract_id));
        return "home/contracts/view_contract";
    }

    /*
    Method for deleting Contracts:
    @GetMapping annotation containing the /deleteContract path and attachment of contract_id
    - The method contains the @Pathvariable to get ("contract_id")
    - The method puts it into variable int contract_id
    - Creation of boolean called deleted
    - Usage of contractService object to access deleteContract(contract_id)
    - Creation of if/else statement
    - If created -> returns redirect to Show Contracts
    - If not created -> returns redirect to Show Contracts
     */
    @GetMapping("/deleteContract/{contract_id}")
    public String deleteContract(@PathVariable("contract_id")int contract_id) {
        boolean delete = contractService.deleteContract(contract_id);
        if(delete) {
            return "redirect:/showContracts";
        } else {
            return "redirect:/showContracts";
        }
    }

    /*
    Method for updating Contracts:
    @GetMapping annotation containing the /updateContract path and attachment of contract_id
    - The method contains the @pathvariable to get ("contract_id")
    - The method puts it into the variable int contract_id
    - The method creates the model object to display
    - Usage of the addAttribute from model named "contracts"
    - Usage of contractService object to access findContractByID(contract_id)
    - Returns update contract html page
     */
    @GetMapping("/updateContract/{contract_id}")
    public String updateContract(@PathVariable("contract_id")int contract_id, Model model){
        model.addAttribute("contracts", contractService.findContractByID(contract_id));
        return "home/contracts/update_contract";
    }

    /*
    Method for updating Contracts:
    @PostMapping annotation containing the /updateContract path
    - Usage of @ModelAttribute for making model and addAttribute to the created object "contract"
    - Usage of contractService for updateContract function, containing getter and the object
    - Returns Contracts html page
     */
    @PostMapping("/updateContract")
    public String updateContract(@ModelAttribute Contract contract){
        contractService.updateContract(contract.getContract_id(), contract);
        return "redirect:/showContracts";
    }
}