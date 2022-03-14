package com.gestion_ressource.micro_authentification.repository;

import com.gestion_ressource.micro_authentification.model.ERole;
import com.gestion_ressource.micro_authentification.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}
