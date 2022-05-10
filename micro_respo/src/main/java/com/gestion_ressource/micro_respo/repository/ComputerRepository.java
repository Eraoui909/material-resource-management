package com.gestion_ressource.micro_respo.repository;

import com.gestion_ressource.micro_respo.model.Computer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ComputerRepository extends MongoRepository<Computer, String> {
    @Query("{ 'CPU': { $exists: true } }")
    List<Computer> getAllComputers();

    @Query("{ 'affectedToOwner.username' : ?0 }")
    List<Computer> getResourcesByOwnerUsername(String username);



}
