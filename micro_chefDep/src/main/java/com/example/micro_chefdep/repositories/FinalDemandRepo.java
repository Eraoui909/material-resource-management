package com.example.micro_chefdep.repositories;

import com.example.micro_chefdep.models.Demand;
import com.example.micro_chefdep.models.FinalDemand;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FinalDemandRepo extends MongoRepository<FinalDemand,String> {
    List<Demand> findAllBySenderOrderByIdDesc(String user);
}
