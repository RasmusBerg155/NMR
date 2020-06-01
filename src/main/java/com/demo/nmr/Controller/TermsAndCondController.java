package com.demo.nmr.Controller;

import com.demo.nmr.Model.TermsAndCond;
import com.demo.nmr.Service.TermsAndCondService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

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
}
