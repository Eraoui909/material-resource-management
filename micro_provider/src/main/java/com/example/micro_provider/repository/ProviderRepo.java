package com.example.micro_provider.repository;
import com.example.micro_provider.models.Provider;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface ProviderRepo extends MongoRepository<Provider,String> {

    @Query("{'email' : '?0'}")
    Provider findProviderByEmail(String email);

    @Query("{'authorities.name' : 'ROLE_PROVIDER'}")
    List<Provider> findAllProviders();

}
