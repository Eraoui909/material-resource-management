package com.example.micro_enseignant.repository;

import com.example.micro_enseignant.models.DemandRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DemandRequestRepo extends MongoRepository<DemandRequest,String> {
    DemandRequest findFirstByOrderByIdDesc();

    DemandRequest findFirstByDepartmentOrderByIdDesc(String dep);
//    List<Enseignant> findEnseignantsByDepartement(String departement);
}
