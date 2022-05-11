package com.example.micro_respomaintenance.repo;

import com.example.micro_respomaintenance.models.Resource;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface RepoRessource extends MongoRepository<Resource, String> {
    @Query("{ 'panne': {$ne:?0}}")
    List<Resource> getAllResources(String var);
}
