package com.example.micro_respomaintenanceee.repo;

import com.example.micro_respomaintenanceee.models.RespoMaintenance;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepoMaintenance extends MongoRepository<RespoMaintenance , String> {
}
