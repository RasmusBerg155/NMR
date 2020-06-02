package com.demo.nmr.Controller;

import com.demo.nmr.Model.TermsAndCond;
import com.demo.nmr.Service.TermsAndCondService;
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
public class TermsAndCondController {

    @Autowired
    TermsAndCondService termsAndCondService;

    @GetMapping("/ShowTermsAndCond")
    public String showTermsAndCond(Model model){
        List<TermsAndCond> termsAndCondList = termsAndCondService.fetchAll();
        model.addAttribute("termsandcond", termsAndCondList);
        return "home/termsandconditions/termsandcond";
    }

    @GetMapping("/createTC")
    public String createTC(){
        return "home/termsandconditions/create_tc";
    }

    @PostMapping("/createTC")
    public String createTC(@ModelAttribute TermsAndCond termsAndCond){
        termsAndCondService.addTermsAndCond(termsAndCond);
        return "redirect:/ShowTermsAndCond";
    }

    @GetMapping("/viewTC/{tc_id}")
    public String viewTC(@PathVariable("tc_id") int tc_id, Model model){
        model.addAttribute("termsandcond", termsAndCondService.findTermsAndCondById(tc_id));
        return "home/termsandconditions/view_tc";
    }

    @GetMapping("/deleteTC/{tc_id}")
    public String deleteTC(@PathVariable("tc_id") int tc_id){
        boolean deleted = termsAndCondService.deleteTermsAndCond(tc_id);
        if (deleted){
            return "redirect:/ShowTermsAndCond";
        } else {
            return "redirect:/ShowTermsAndCond";
        }
    }

    @GetMapping("/updateTC/{tc_id}")
    public String updateTermsAndCond(@PathVariable("tc_id") int tc_id, Model model){
        model.addAttribute("termsandcond", termsAndCondService.findTermsAndCondById(tc_id));
        return "home/termsandconditions/update_tc";
    }

    @PostMapping("updateTC")
    public String updateTermsandCond(@ModelAttribute TermsAndCond termsAndCond){
        termsAndCondService.updateTermsAndCond(termsAndCond.getTc_id(), termsAndCond);
        return "redirect:/ShowTermsAndCond";
    }
}
