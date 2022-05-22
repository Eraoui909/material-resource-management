package com.gestion_ressource.micro_respo.repository;

import com.gestion_ressource.micro_respo.model.Offer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface OffreProvidersRepo extends MongoRepository<Offer, String> {

    @Query("{ 'providers': { $exists: true } }")
    List<Offer> getAllOffers();


}
