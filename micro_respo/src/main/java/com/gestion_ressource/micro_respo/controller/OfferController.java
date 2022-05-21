package com.gestion_ressource.micro_respo.controller;

import com.gestion_ressource.micro_respo.model.Demand;
import com.gestion_ressource.micro_respo.model.Offers;
import com.gestion_ressource.micro_respo.repository.DemandRepository;
import com.gestion_ressource.micro_respo.repository.OffersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/offer")
@Slf4j
public class OfferController {

    @Autowired
    OffersRepository offers;

    @Autowired
    DemandRepository demand;

    @GetMapping("/")
    public List<Offers> getallOffer(){
        return offers.findAll();
    }

    @PostMapping("/addtolist")
    public Offers addOffer(@RequestBody Offers offer){
        return offers.save(offer);
    }

    @GetMapping("/demands")
    public List<Demand> getallDemand(){
        return demand.findAll();
    }

}
