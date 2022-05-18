package com.example.micro_respomaintenanceee.repo;

import com.example.micro_respomaintenanceee.models.Resource;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepoRessource extends MongoRepository<Resource, String> {
}
