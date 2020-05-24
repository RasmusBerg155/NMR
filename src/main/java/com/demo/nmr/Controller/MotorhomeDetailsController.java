package com.demo.nmr.Controller;

import com.demo.nmr.Model.MotorhomeDetails;
import com.demo.nmr.Service.MotorhomeDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MotorhomeDetailsController {
    @Autowired
    MotorhomeDetailsService motorhomeDetailsService;

    @GetMapping("/ShowMotorhomeDetails")
    public String showMotorhomeDetails(Model model){
        List<MotorhomeDetails> motorhomeDetailsList = motorhomeDetailsService.fetchAll();
        model.addAttribute("motorhomedetails", motorhomeDetailsList);
        return "home/motorhomes/motorhomedetails";
    }
}
