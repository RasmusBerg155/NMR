package com.demo.nmr.Controller;

import com.demo.nmr.Model.Motorhome;
import com.demo.nmr.Service.MotorhomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MotorhomeController {
    @Autowired
    MotorhomeService motorhomeService;

    @GetMapping("/ShowMotorhomes")
    public String showMotorhomes(Model model){
        List<Motorhome> motorhomeList = motorhomeService.fetchAll();
        model.addAttribute("motorhomes", motorhomeList);
        return "home/motorhomes/motorhomes";
    }
    @GetMapping("/create")
        public String create(){
         return "home/motorhomes/CreateMhomes";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Motorhome motorhome){
        motorhomeService.addMotorhome(motorhome);
        return "redirect:/";
    }
}
