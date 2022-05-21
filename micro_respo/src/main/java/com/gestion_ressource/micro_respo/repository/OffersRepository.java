package com.gestion_ressource.micro_respo.repository;

import com.gestion_ressource.micro_respo.model.Offer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OffersRepository extends MongoRepository<Offer, String> {
}
