package com.admin.admin.repositries;

import com.admin.admin.models.Enseignant;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EnseignantRepo extends MongoRepository<Enseignant,String> {
}
