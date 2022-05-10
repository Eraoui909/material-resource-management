package com.example.micro_enseignant.repository;

import com.example.micro_enseignant.models.Panne;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface PanneRepo extends MongoRepository<Panne, String> {
}
