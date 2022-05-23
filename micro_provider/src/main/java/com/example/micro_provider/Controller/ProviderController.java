package com.example.micro_provider.Controller;

import com.example.micro_provider.models.Offer;
import com.example.micro_provider.models.Provider;
import com.example.micro_provider.repository.OfferRepo;
import com.example.micro_provider.repository.ProviderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/providers")

public class ProviderController {

    @Autowired
    private ProviderRepo providerRepo;
    @Autowired
    private OfferRepo offerRepo;
    @GetMapping
    public List<Provider> findAllProviders(){
        return providerRepo.findAllProviders();
    }

    @GetMapping("/myStatus/{email}")
    public String getStatus(@PathVariable String email){

         return providerRepo.findProviderByEmail(email).getStatus();

    }

    @PostMapping
    public Offer addOffretoProvider(@RequestBody Provider provider){
        System.out.println(provider.toString());
        Provider pr = providerRepo.findProviderByEmail(provider.getEmail());
        pr.setPrice(provider.getPrice());
        Offer offer = offerRepo.findById(provider.getOffers().get(0).getId()).get();

        List<Provider> providers = new ArrayList<>();
        providers.add(pr);
        if (offer.getProviders() != null){
            providers.addAll(offer.getProviders());
        }
        offer.setProviders(providers);
        offer.setStatus("Offred");



        return offerRepo.save(offer);
    }



}
