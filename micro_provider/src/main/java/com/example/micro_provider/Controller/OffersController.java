package com.example.micro_provider.Controller;


import com.example.micro_provider.models.Offer;
import com.example.micro_provider.repository.OfferRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/providers/offres")
public class OffersController {
    @Autowired
    private OfferRepo offerRepo;

    @GetMapping
    public List<Offer> getAllOffers(){
        return offerRepo.findAll();
    }
}
