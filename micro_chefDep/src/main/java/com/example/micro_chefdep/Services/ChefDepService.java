package com.example.micro_chefdep.Services;

import com.example.micro_chefdep.models.ChefDep;
import com.example.micro_chefdep.repositories.ChefDefRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ChefDepService {
    private ChefDefRepo chefDefRepo;

    @Transactional
    public void updateChefDep( String id,  ChefDep chefDep){
        ChefDep c = chefDefRepo.findById(id).orElseThrow(()-> new IllegalStateException("ChefDep doesnt exist"));
        c.setEmail(chefDep.getEmail());
        c.setName(chefDep.getName());
        c.setAddress(chefDep.getAddress());
        c.setDepartement(chefDep.getDepartement());
        c.setPhone(chefDep.getPhone());
    }
}
