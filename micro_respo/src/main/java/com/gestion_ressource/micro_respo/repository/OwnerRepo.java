package com.gestion_ressource.micro_respo.repository;
import com.gestion_ressource.micro_respo.model.Owner;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OwnerRepo extends MongoRepository<Owner,String> {
}
