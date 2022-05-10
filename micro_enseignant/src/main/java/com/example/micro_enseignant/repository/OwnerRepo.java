package com.example.micro_enseignant.repository;
import com.example.micro_enseignant.models.Owner;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface OwnerRepo extends MongoRepository<Owner,String> {


    Optional<Owner> findByUsername(String username);

    Optional<Owner> findByDepartment(String dep);
}
