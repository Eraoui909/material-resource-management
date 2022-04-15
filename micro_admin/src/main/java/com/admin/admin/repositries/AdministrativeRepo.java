package com.admin.admin.repositries;

import com.admin.admin.models.Administrative;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdministrativeRepo extends MongoRepository<Administrative,String> {
}
