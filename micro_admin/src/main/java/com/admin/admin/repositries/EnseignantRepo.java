package com.admin.admin.repositries;

import com.admin.admin.models.Enseignant;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface EnseignantRepo extends MongoRepository<Enseignant,String> {
    List<Enseignant> findByLaboratoire(String name);
}
