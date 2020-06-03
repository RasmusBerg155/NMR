package com.demo.nmr.Controller;

import com.demo.nmr.Model.Motorhome;
import com.demo.nmr.Model.MotorhomeDetails;
import com.demo.nmr.Service.MotorhomeDetailsService;
import com.demo.nmr.Service.MotorhomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/*
---- Made By Alin Cristian Bejinariu, Rasmus Marco Berg ----

Comments for explanation of all classes are implemented in:
Contract, ContractRepo, ContractService, ContractController, HomeController
 */

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

    @GetMapping("/createMH")
    public String createMH(){
         return "home/motorhomes/create_mh";
    }

    @PostMapping("/createMH")
    public String createMH(@ModelAttribute Motorhome motorhome){
        motorhomeService.addMotorhome(motorhome);
        return "redirect:/ShowMotorhomes";
    }

    @GetMapping("/viewMH/{motorhome_id}")
    public String viewMH(@PathVariable("motorhome_id")int motorhome_id, Model model){
        model.addAttribute("motorhomes", motorhomeService.findMotorhomeById(motorhome_id));
        return "home/motorhomes/view_mh";
    }

    @GetMapping("/deleteMH/{motorhome_id}")
    public String deleteMH(@PathVariable("motorhome_id")int motorhome_id) {
        boolean deleted = motorhomeService.deleteMotorhome(motorhome_id);
        if(deleted) {
            return "redirect:/ShowMotorhomes";
        } else {
            return "redirect:/ShowMotorhomes";
        }
    }

    @GetMapping("/updateMH/{motorhome_id}")
    public String updateMH(@PathVariable("motorhome_id")int motorhome_id, Model model){
        model.addAttribute("motorhomes", motorhomeService.findMotorhomeById(motorhome_id));
        return "home/motorhomes/update_mh";
    }

    @PostMapping("/updateMH")
    public String updateMH(@ModelAttribute Motorhome motorhome){
        motorhomeService.updateMotorhome(motorhome.getMotorhome_id(), motorhome);
        return "redirect:/ShowMotorhomes";
    }
}