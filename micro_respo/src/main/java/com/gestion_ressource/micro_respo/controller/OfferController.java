package com.gestion_ressource.micro_respo.controller;

import com.gestion_ressource.micro_respo.model.Demand;
import com.gestion_ressource.micro_respo.model.Offer;
import com.gestion_ressource.micro_respo.repository.DemandRepository;
import com.gestion_ressource.micro_respo.repository.OffersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public List<Offer> getallOffer(){
        return offers.findAll();
    }

    @PostMapping("/addtolist")
    public Offer addOffer(@RequestBody Offer offer){
        return offers.save(offer);
    }

    @GetMapping("/demands")
    public List<Demand> getAllDemand(){
        return demand.getAllDemand();
    }

    @GetMapping("/demand/{id}")
    public Demand getDemandById(@PathVariable String id){
        Demand r = demand.findById(id).get();
        r.setStatus("Offered");
        return demand.save(r);
    }
}
