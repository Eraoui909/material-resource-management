package com.admin.admin.repositries;

import com.admin.admin.models.Enseignant;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EnseignantRepo extends MongoRepository<Enseignant,String> {

    Enseignant findEnseignantsById(String id);

    List<Enseignant> findByLaboratoire(String name);
    @Query("{'authorities.name' : 'ROLE_PROF'}")
    List<Enseignant> findEnseignants();

    Optional<Enseignant> findEnseignantsByEmail(String email);




}
