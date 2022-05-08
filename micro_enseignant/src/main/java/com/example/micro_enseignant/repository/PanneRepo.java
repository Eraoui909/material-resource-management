package com.example.micro_enseignant.repository;

import com.example.micro_enseignant.models.Panne;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PanneRepo extends MongoRepository<Panne, String> {
}
