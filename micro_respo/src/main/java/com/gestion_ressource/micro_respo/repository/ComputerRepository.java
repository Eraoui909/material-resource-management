package com.gestion_ressource.micro_respo.repository;

import com.gestion_ressource.micro_respo.model.Computer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ComputerRepository extends MongoRepository<Computer, String> {
}
