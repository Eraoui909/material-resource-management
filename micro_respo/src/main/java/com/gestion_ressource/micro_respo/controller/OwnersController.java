package com.gestion_ressource.micro_respo.controller;

import com.gestion_ressource.micro_respo.model.Owner;
import com.gestion_ressource.micro_respo.repository.OwnerRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/owners")
@Slf4j
public class OwnersController {

    @Autowired
    private OwnerRepo repo;

    @GetMapping("/")
    public List<Owner> getAll(){
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Owner> getById(@PathVariable String id){
        return repo.findById(id);
    }

    @GetMapping("/name/{name}")
    public Optional<Owner> getByUsername(@PathVariable String name){
        return repo.findByUsername(name);
    }

    @GetMapping("/departement/{name}")
    public Optional<Owner> getByLaboratoire(@PathVariable String name){
        return repo.findByDepartment(name);
    }

}