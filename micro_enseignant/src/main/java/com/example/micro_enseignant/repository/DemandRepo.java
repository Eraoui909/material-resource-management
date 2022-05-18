package com.example.micro_enseignant.repository;

import com.example.micro_enseignant.models.Demand;
import com.example.micro_enseignant.models.DemandRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DemandRepo extends MongoRepository<Demand,String> {
    List<Demand> findAllBySenderOrderByIdDesc(String user);
}
