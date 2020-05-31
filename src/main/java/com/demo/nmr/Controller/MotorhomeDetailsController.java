package com.demo.nmr.Controller;

import com.demo.nmr.Model.MotorhomeDetails;
import com.demo.nmr.Service.MotorhomeDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MotorhomeDetailsController {
    @Autowired
    MotorhomeDetailsService motorhomeDetailsService;

    @GetMapping("/ShowMotorhomeDetails")
    public String showMotorhomeDetails(Model model){
        List<MotorhomeDetails> motorhomeDetailsList = motorhomeDetailsService.fetchAll();
        model.addAttribute("motorhomedetails", motorhomeDetailsList);
        return "home/motorhomedetails/motorhomedetails";
    }

    @GetMapping("/CreateMotorhomeDetails")
    public String createMotorhomeDetails(){
        return "home/motorhomedetails/create_md";
    }

    @PostMapping("/CreateMotorhomeDetails")
    public String createMotorhomeDetails(@ModelAttribute MotorhomeDetails motorhomeDetails){
        motorhomeDetailsService.addMotorhomeDetails(motorhomeDetails);
        return "redirect:/";
    }

    @GetMapping("/ViewOneMotorhomeDetail/{motorhome_detail_id}")
    public String viewOneMotorhomeDetail(@PathVariable("motorhome_detail_id") int motorhome_detail_id, Model model){
       model.addAttribute("motorhomedetails", motorhomeDetailsService.findMotorhomeDetailsById(motorhome_detail_id));
       return "home/motorhomedetails/view_md";
    }

    @GetMapping("/DeleteMotorhomeDetails/{motorhome_detail_id}")
    public String deleteMotorhomeDetails(@PathVariable("motorhome_detail_id") int motorhome_detail_id){
        boolean deleted = motorhomeDetailsService.deleteMotorhomeDetailsById(motorhome_detail_id);
        if(deleted){
            return "redirect:/";
        }else{
            return "redirect:/";
        }
    }

    @GetMapping("/UpdateMotorhomeDetails/{motorhome_detail_id}")
    public String updateMotorhomeDetailsId(@PathVariable("motorhome_detail_id") int motorhome_detail_id, Model model){
        model.addAttribute("motorhomedetails", motorhomeDetailsService.findMotorhomeDetailsById(motorhome_detail_id));
        return "home/motorhomedetails/update_md";
    }

    @PostMapping("/UpdateMotorhomeDetails")
    public String updateMotorhomeDetails(@ModelAttribute MotorhomeDetails motorhomeDetails){
        motorhomeDetailsService.updateMotorhomeDetailsById(motorhomeDetails.getMotorhome_detail_id(), motorhomeDetails);
        return "redirect:/";
    }
}
