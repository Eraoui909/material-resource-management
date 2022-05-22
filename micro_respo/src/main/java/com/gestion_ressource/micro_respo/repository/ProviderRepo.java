package com.gestion_ressource.micro_respo.repository;
import com.gestion_ressource.micro_respo.model.Provider;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProviderRepo extends MongoRepository<Provider,String> {

    @Query("{'email' : '?0'}")
    Provider findProviderByEmail(String email);

    @Query("{'authorities.name' : 'ROLE_PROVIDER'}")
    List<Provider> findAllProviders();

}
