package com.example.micro_chefdep.repositories;

import com.example.micro_chefdep.models.Demand;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DemandRepo extends MongoRepository<Demand,String> {
    List<Demand> findAllBySenderOrderByIdDesc(String user);
}
