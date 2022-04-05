package com.example.micro_enseignant.repository;

import com.example.micro_enseignant.models.Enseignant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnseignantRepo extends MongoRepository<Enseignant,String> {
}
