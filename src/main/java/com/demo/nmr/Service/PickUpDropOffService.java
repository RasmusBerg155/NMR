package com.demo.nmr.Service;


import com.demo.nmr.Model.PickUpDropOff;
import com.demo.nmr.Repository.PickUpDropOffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PickUpDropOffService {
    @Autowired
    PickUpDropOffRepo pickUpDropOffRepo;

    public List<PickUpDropOff> fetchAll(){
        return pickUpDropOffRepo.fetchAll();
    }

    public PickUpDropOff addPickUpDropOff(PickUpDropOffRepo p){
        return pickUpDropOffRepo.addPickUpDropOff(p);
    }

    public PickUpDropOff findPickUpDropOffById(int pd_id){
        return pickUpDropOffRepo.findPickUpDropOffById(pd_id);
    }

    public Boolean deletePickUpDropOff(int pd_id){
        return pickUpDropOffRepo.deletePickUpDropOff(pd_id);
    }

    public PickUpDropOff updatePickUpDropOff(int pd_id, PickUpDropOffRepo p){
        return pickUpDropOffRepo.updatePickUpDropOff(pd_id, p);
    }
}