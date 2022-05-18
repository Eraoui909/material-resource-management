package com.example.micro_chefdep.repositories;

import com.example.micro_chefdep.models.DemandRequest;
import com.example.micro_chefdep.models.Enseignant;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DemandRequestRepo extends MongoRepository<DemandRequest,String> {
//    List<Enseignant> findEnseignantsByDepartement(String departement);
}
