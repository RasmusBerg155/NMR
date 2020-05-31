package com.demo.nmr.Controller;


import com.demo.nmr.Model.PickUpDropOff;
import com.demo.nmr.Service.PickUpDropOffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PickUpDropOffController {

    @Autowired
    PickUpDropOffService pickUpDropOffService;

    @GetMapping("/ShowPickUpDropOff")
    public String showPickOffDropOff(Model model){
        List<PickUpDropOff> pickUpDropOffList = pickUpDropOffService.fetchAll();
        model.addAttribute("pickupdropoff", pickUpDropOffList);
        return "home/pickupdropoff/pickupdropoff";
    }

    @GetMapping("/createDP")
    public String createDP() {
        return "home/pickupdropoff/create_pd";
    }

    @PostMapping("/createDP")
    public String createDP(@ModelAttribute PickUpDropOff pickUpDropOff){
        pickUpDropOffService.addPickUpDropOff(pickUpDropOff);
        return "redirect:/";
    }

    @GetMapping("/viewPD/{pd_id}")
    public String viewPD(@PathVariable("pd_id") int pd_id, Model model){
        model.addAttribute("pickupdropoff", pickUpDropOffService.findPickUpDropOffById(pd_id));
        return "home/pickupdropoff/view_pd";
    }

    @GetMapping("/deletePD/{pd_id}")
    public String delete(@PathVariable("pd_id") int pd_id){
        boolean deleted = pickUpDropOffService.deletePickUpDropOff(pd_id);
        if (deleted) {
            return "redirect:/";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/updatePD/{pd_id}")
    public String updatePickUpDropOffById(@PathVariable("pd_id") int pd_id, Model model){
        model.addAttribute("pickupdropoff", pickUpDropOffService.findPickUpDropOffById(pd_id));
        return "home/pickupdropoff/update_pd";
    }

    @PostMapping("/updatePD")
    public String updatePickUpDropOff(@ModelAttribute PickUpDropOff pickUpDropOff){
        pickUpDropOffService.updatePickUpDropOff(pickUpDropOff.getPd_id(), pickUpDropOff);
        return "redirect:/";
    }
}