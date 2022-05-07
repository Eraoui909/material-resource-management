package com.admin.admin.repositries;

import com.admin.admin.models.Administrative;
import com.admin.admin.models.Enseignant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface AdministrativeRepo extends MongoRepository<Administrative,String> {
    @Query("{'authorities.name' : 'ROLE_ADMINISTRATIVE'}")
    List<Administrative> findAdministrative();
}
