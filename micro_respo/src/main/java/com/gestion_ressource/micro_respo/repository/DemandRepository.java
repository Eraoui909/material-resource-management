package com.gestion_ressource.micro_respo.repository;

import com.gestion_ressource.micro_respo.model.Demand;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface DemandRepository extends MongoRepository<Demand, String> {
    @Query("{'status' : 'Sent'}")
    List<Demand> getAllDemand();
}
