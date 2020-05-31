package com.demo.nmr.Controller;


import com.demo.nmr.Model.CustomerContacts;
import com.demo.nmr.Service.CustomerContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CustomerContactsController {

    @Autowired
    CustomerContactsService customerContactsService;

    @GetMapping("/ShowCustomerContacts")
    public String showCustomerContracts(Model model){
        List<CustomerContacts> customerContactsList = customerContactsService.fetchAll();
        model.addAttribute("CustomerContacts", customerContactsList);
        return "home/customercontacts/customercontacts";
    }

    @GetMapping("/CreateCustomerContacts")
    public String createCustomerContacts(){
        return "home/customercontacts/create_ct";
    }

    @PostMapping("/CreateCustomerContacts")
    public String createCustomerContacts(@ModelAttribute CustomerContacts customerContacts){
        customerContactsService.addCustomerContacts(customerContacts);
        return "redirect:/";
    }

    @GetMapping("/ViewOneCustomerContacts/{contact_id}")
    public String viewOneCustomerContacts(@PathVariable("contact_id") int contact_id, Model model){
        model.addAttribute("customercontacts", customerContactsService.findCustomerContactById(contact_id));
        return "home/customercontacts/view_ct";
    }

    @GetMapping("/DeleteCustomerContacts/{contact_id}")
    public String deleteCustomerContacts(@PathVariable("contact_id") int contact_id){
        boolean deleted = customerContactsService.deleteCustomerContacts(contact_id);
        if(deleted){
            return "redirect:/";
        }else{
            return "redirect:/";
        }
    }

    @GetMapping("/UpdateCustomerContacts/{contact_id}")
    public String updateCustomerContacts(@PathVariable("contact_id") int contact_id, Model model){
        model.addAttribute("customercontacts", customerContactsService.findCustomerContactById(contact_id));
        return "home/customercontacts/update_ct";
    }

    @PostMapping("/UpdateCustomerContacts")
    public String updateCustomerContacts(@ModelAttribute CustomerContacts customerContacts){
        customerContactsService.updateCustomerContacts(customerContacts.getContact_id(), customerContacts);
        return "redirect:/";
    }
}
