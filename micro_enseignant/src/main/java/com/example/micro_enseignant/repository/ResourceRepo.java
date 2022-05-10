package com.example.micro_enseignant.repository;

import com.example.micro_enseignant.models.Resource;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ResourceRepo extends MongoRepository<Resource, String> {

    @Query("{ 'affectedToOwner.username' : ?0 }")
    List<Resource> getResourcesByOwnerUsername(String username);



}