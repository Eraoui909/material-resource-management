package com.example.micro_provider.Controller;

import com.example.micro_provider.models.Offer;
import com.example.micro_provider.models.Provider;
import com.example.micro_provider.repository.ProviderRepo;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/providers")

public class ProviderController {

    @Autowired
    private ProviderRepo providerRepo;

    @GetMapping
    public List<Provider> findAllProviders(){
        return providerRepo.findAllProviders();
    }
    @PostMapping
    public Provider addOffretoProvider(@RequestBody Provider provider){
        System.out.println(provider.toString());
        Provider pr = providerRepo.findProviderByEmail(provider.getEmail());
        pr.setOffers(provider.getOffers());
        return providerRepo.save(pr);
    }



}
