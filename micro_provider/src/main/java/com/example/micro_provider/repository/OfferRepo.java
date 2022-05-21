package com.example.micro_provider.repository;

import com.example.micro_provider.models.Offer;
import com.example.micro_provider.models.Resource;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepo extends MongoRepository<Offer, String> {

//    @Query("{ 'affectedToOwner.username' : ?0 }")
//    List<Resource> getResourcesByOwnerUsername(String username);

}