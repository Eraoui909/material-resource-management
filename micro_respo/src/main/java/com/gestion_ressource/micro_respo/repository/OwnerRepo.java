package com.gestion_ressource.micro_respo.repository;
import com.gestion_ressource.micro_respo.model.Owner;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface OwnerRepo extends MongoRepository<Owner,String> {


    Optional<Owner> findByName(String name);

    Optional<Owner> findByLaboratoire(String lab);
}
