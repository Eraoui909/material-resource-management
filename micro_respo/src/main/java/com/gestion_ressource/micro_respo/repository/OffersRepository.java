package com.gestion_ressource.micro_respo.repository;

import com.gestion_ressource.micro_respo.model.Offers;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OffersRepository extends MongoRepository<Offers, String> {
}
