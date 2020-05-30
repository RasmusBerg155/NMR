package com.demo.nmr.Controller;

import com.demo.nmr.Model.PickUpDropOff;
import com.demo.nmr.Service.PickUpDropOffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
