package com.example.micro_chefdep.repositories;

import com.example.micro_chefdep.models.Enseignant;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EnseignantRepo extends MongoRepository<Enseignant,String> {
    List<Enseignant> findEnseignantsByDepartement(String departement);
}
