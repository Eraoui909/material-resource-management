package com.gestion_ressource.micro_authentification.repository;

import com.gestion_ressource.micro_authentification.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findFirstByUsername(String username);
    Boolean existsByEmail(String email);
    Boolean existsByUsername(String email);
}
