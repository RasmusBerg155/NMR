package com.demo.nmr.Service;


import com.demo.nmr.Model.PickUpDropOff;
import com.demo.nmr.Repository.PickUpDropOffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


//Service Class for MotorhomeDetails containing:
//Implementation of methods from MotorhomeDetailsRepo Class
//It's Autowired to access the Repository objects

@Service
public class PickUpDropOffService {

    //Autowiring of the PickUpDropOffRepo Class and creation of pickUpDropOffRepo object
    @Autowired
    PickUpDropOffRepo pickUpDropOffRepo;

    public List<PickUpDropOff> fetchAll(){
        return pickUpDropOffRepo.fetchAll();
    }

    public PickUpDropOff addPickUpDropOff(PickUpDropOff p){
        return pickUpDropOffRepo.addPickUpDropOff(p);
    }

    public PickUpDropOff findPickUpDropOffById(int pd_id){
        return pickUpDropOffRepo.findPickUpDropOffById(pd_id);
    }

    public boolean deletePickUpDropOff(int pd_id){
        return pickUpDropOffRepo.deletePickUpDropOff(pd_id);
    }

    public PickUpDropOff updatePickUpDropOff(int pd_id, PickUpDropOff p){
        return pickUpDropOffRepo.updatePickUpDropOff(pd_id, p);
    }
}