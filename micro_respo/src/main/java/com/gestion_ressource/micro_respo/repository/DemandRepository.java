package com.gestion_ressource.micro_respo.repository;

import com.gestion_ressource.micro_respo.model.Demand;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DemandRepository extends MongoRepository<Demand, String> {
}
