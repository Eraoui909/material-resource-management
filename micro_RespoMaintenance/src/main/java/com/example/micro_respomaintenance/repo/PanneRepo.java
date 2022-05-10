package com.example.micro_respomaintenance.repo;

import com.example.micro_respomaintenance.models.Panne;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PanneRepo extends MongoRepository<Panne, String> {
}
