package com.example.micro_chefdep.repositories;

import com.example.micro_chefdep.models.ChefDep;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChefDefRepo extends MongoRepository<ChefDep,String> {

}
