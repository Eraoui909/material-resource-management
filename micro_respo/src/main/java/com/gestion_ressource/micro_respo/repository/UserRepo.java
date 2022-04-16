package com.gestion_ressource.micro_respo.repository;
import com.gestion_ressource.micro_respo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User,String> {
}
