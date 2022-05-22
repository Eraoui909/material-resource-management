package com.gestion_ressource.micro_respo.controller;

import com.gestion_ressource.micro_respo.model.Offer;
import com.gestion_ressource.micro_respo.model.Provider;
import com.gestion_ressource.micro_respo.repository.OffreProvidersRepo;
import com.gestion_ressource.micro_respo.repository.ProviderRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/offre/Providers")
@Slf4j
public class OffreProvidersController {
    @Autowired
    private OffreProvidersRepo offreProvidersRepo;
    @Autowired
    private ProviderRepo providerRepo;
    @GetMapping
    public List<Offer> getAllOfferProviders(){
        return offreProvidersRepo.getAllOffers();
    }
    @GetMapping("/delete/{ids}")
    public Offer deleteProvider(@PathVariable String ids){
        String[] idss = ids.split(",");
        Offer offer = offreProvidersRepo.findById(idss[0]).get();

        List<Provider> providers = new ArrayList<>();

        for (Provider p: offer.getProviders()) {
            if (!p.getId().equals(idss[1])){
                providers.add(p);
            }
        }
        offer.setProviders(providers);
        if (offer.getProviders().size() == 0){
            offer.setStatus("En cours De traitement");
            offer.setProviders(null);
        }


        return offreProvidersRepo.save(offer);
    }
}
