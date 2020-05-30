package com.demo.nmr.Controller;
/* import com.demo.nmr.Model.customerContacts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@Controller
public class customerContactsController<Customer> {
    @Autowired
    com.demo.nmr.Service.customerContactsService customerContactsService;

    @GetMapping("/")
    public String index(Model model){
        List<customerContacts> customerContactsList = customerContactsService.fetchAll();
        model.addAttribute("CustomerContacts", customerContactsList);
        return "home/index";
    }

    @GetMapping("/CreateCustomerContact")
    public String CreateCustomerContact(){
        return "home/CreateCustomerContact";
    }

    @PostMapping("/CreateCustomerContact")
    public String CreateCustomerContact(@ModelAttribute customerContacts customerContacts){
        customerContactsService.addcustomerContacts(customerContacts);
        return "redirect:/";
    }

    @GetMapping("/SeeOneContact/{contact_id}")
    public String SeeOneContact(@PathVariable("contact_id") int contact_id, Model model){
        model.addAttribute("customerContact", customerContactsService.findCustomerContactById(contact_id));
        return "home/SeeOneContact";
    }

    @GetMapping("/DeleteCustomerContacts/{contact_id}")
    public String DeleteCustomerContacts(@PathVariable("contact_id") int contact_id){
        boolean CustomerContactsDeleted = customerContactsService.deleteCustomerContacts(contact_id);
        if (CustomerContactsDeleted){
            return "redirect:/";
        }else{
            return "redirect:/";
        }
    }

    @GetMapping("/UpdateCustomerContacts/{contact_id}")
    public String UpdateCustomerContacts(@PathVariable("contact_id") int contact_id, Model model){
        model.addAttribute("customerContact", customerContactsService.findCustomerContactById(contact_id));
        return "home/UpdateCustomerContacts";  //the "customerContact" must be the same written in HTML
    }

    @PostMapping("/UpdateCustomerContacts")
    public String UpdateCustomerContacts(@ModelAttribute customerContacts customerContacts){
        customerContactsService.updateCustomerContacts(customerContacts.getContact_id(), customerContacts);
        return "redirect:/";
    }
} */
