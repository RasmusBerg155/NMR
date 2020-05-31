package com.demo.nmr.Controller;

import com.demo.nmr.Model.CustomerAddresses;
import com.demo.nmr.Model.MotorhomeDetails;
import com.demo.nmr.Service.CustomerAddressesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CustomerAddressesController {
  @Autowired
  CustomerAddressesService customerAddressesService;

    @GetMapping("/ShowCustomerAddresses")
    public String showCustomerAddresses(Model model){
        List<CustomerAddresses> customerAddressesList = customerAddressesService.fetchAll();
        model.addAttribute("customeraddresses", customerAddressesList);
        return "home/customeraddresses/customeraddresses";
    }

    @GetMapping("/CreateCustomerAddresses")
    public String createCustomerAddresses(){
        return "home/customeraddresses/create_ca";
    }

    @PostMapping("/CreateCustomerAddresses")
    public String createCustomerAddresses(@ModelAttribute CustomerAddresses customerAddresses){
        customerAddressesService.addCustomerAddresses(customerAddresses);
        return "redirect:/";
    }

    @GetMapping("/ViewOneCustomerAddresses/{address_id}")
    public String viewOneCustomerAddresses(@PathVariable("address_id") int address_id, Model model){
        model.addAttribute("customeraddresses", customerAddressesService.findCustomerAddressesById(address_id));
        return "home/customeraddresses/view_ca";
    }

    @GetMapping("/DeleteCustomerAddresses/{address_id}")
    public String deleteCustomerAddresses(@PathVariable("address_id") int address_id){
        boolean deleted = customerAddressesService.deleteCustomerAddresses(address_id);
        if(deleted){
            return "redirect:/";
        }else{
            return "redirect:/";
        }
    }

    @GetMapping("/UpdateCustomerAddresses/{address_id}")
    public String updateCustomerAddresses(@PathVariable("address_id") int address_id, Model model){
        model.addAttribute("customeraddresses", customerAddressesService.findCustomerAddressesById(address_id));
        return "home/customeraddresses/update_ca";
    }

    @PostMapping("/UpdateCustomerAddresses")
    public String updateCustomerAddresses(@ModelAttribute CustomerAddresses customerAddresses){
        customerAddressesService.updateCustomerAddresses(customerAddresses.getAddress_id(), customerAddresses);
        return "redirect:/";
    }

}

