package com.admin.admin.repositries;

import com.admin.admin.models.Enseignant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface EnseignantRepo extends MongoRepository<Enseignant,String> {
    List<Enseignant> findByLaboratoire(String name);
    @Query("{'authorities.name' : 'ROLE_PROF'}")
    List<Enseignant> findEnseignants();




}
