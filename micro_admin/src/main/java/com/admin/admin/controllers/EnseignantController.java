package com.admin.admin.controllers;

import com.admin.admin.models.Enseignant;
import com.admin.admin.repositries.EnseignantRepo;
import com.admin.admin.services.EnseignantService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/teachers")
public class EnseignantController {


    @Autowired
    private EnseignantService enseignantService;

    @Autowired
    private EnseignantRepo repo;



    @GetMapping("/")
    public List<Enseignant> getAllTeachers(){
        return repo.findEnseignants();
    }

    @GetMapping("/{id}")
    public Optional<Enseignant> getTeacher(@PathVariable String id){

        return repo.findById(id);
    }

    @GetMapping("/laboratoire/{name}")
    public List<Enseignant> getByLaboratoire(@PathVariable String name){
        return repo.findByLaboratoire(name);
    }

    @PostMapping("/add") @JsonIgnore
    public Enseignant addTeacher(@RequestBody Enseignant e){
        e.setId("54655644654");

        e.setPassword(e.getEmail());
        e.setUsername(e.getEmail());
        System.err.println(e.toString());
        enseignantService.addEnseignant(e);

        return e;
    }

    @PostMapping("/update")
    public Enseignant updateTeacher(@RequestBody Enseignant e){

        return repo.save(e);
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable String id){
        repo.deleteById(id);
    }



}
