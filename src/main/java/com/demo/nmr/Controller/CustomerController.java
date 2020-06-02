package com.demo.nmr.Controller;

import com.demo.nmr.Model.Customer;
import com.demo.nmr.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/*
Comments for explanation of all classes are implemented in:
Contract, ContractRepo, ContractService, ContractController, HomeController
 */

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/ShowCustomer")
    public String showCustomers(Model model){
        List<Customer> customerList = customerService.fetchAll();
        model.addAttribute("customers", customerList);
        return "home/customers/customers";
    }

    @GetMapping("/createCustomer")
    public String createCustomer(){
        return "home/customers/create_customer";
    }

    @PostMapping("/createCustomer")
    public String createCustomer(@ModelAttribute Customer customer){
        customerService.addCustomer(customer);
        return "redirect:/ShowCustomer";
    }

    @GetMapping("/viewCustomer/{customer_id}")
    public String viewCustomer(@PathVariable("customer_id")int customer_id, Model model){
        model.addAttribute("customers", customerService.findCustomerById(customer_id));
        return "home/customers/view_customer";
    }

    @GetMapping("/deleteCustomer/{customer_id}")
    public String deleteCustomer(@PathVariable("customer_id")int customer_id) {
        boolean delete = customerService.deleteCustomer(customer_id);
        if(delete) {
            return "redirect:/ShowCustomer";
        } else {
            return "redirect:/ShowCustomer";
        }
    }

    @GetMapping("/updateCustomer/{customer_id}")
    public String updateMH(@PathVariable("customer_id")int customer_id, Model model){
        model.addAttribute("customers", customerService.findCustomerById(customer_id));
        return "home/customers/update_customer";
    }

    @PostMapping("/updateCustomer")
    public String updateCustomer(@ModelAttribute Customer customer){
        customerService.updateCustomer(customer.getCustomer_id(), customer);
        return "redirect:/ShowCustomer";
    }
}
