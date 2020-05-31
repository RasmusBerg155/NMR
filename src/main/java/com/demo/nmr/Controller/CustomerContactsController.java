package com.demo.nmr.Controller;

import com.demo.nmr.Model.CustomerContacts;
import com.demo.nmr.Service.CustomerContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CustomerContactsController {

    @Autowired
    CustomerContactsService customerContactsService;

    @GetMapping("/ShowCustomerContracts")
    public String showCustomerContracts(Model model){
        List<CustomerContacts> customerContactsList = customerContactsService.fetchAll();
        model.addAttribute("customercontacts", customerContactsList);
        return "home/customercontacts/customercontacts";
    }
}
