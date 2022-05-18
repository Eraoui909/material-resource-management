package com.example.micro_respomaintenance.repo;

import com.example.micro_respomaintenance.models.RespoMaintenance;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepoMaintenance extends MongoRepository<RespoMaintenance , String> {
}
