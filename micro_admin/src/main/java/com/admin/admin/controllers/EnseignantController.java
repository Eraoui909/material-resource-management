package com.admin.admin.controllers;

import com.admin.admin.models.Enseignant;
import com.admin.admin.repositries.EnseignantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/teachers")
public class EnseignantController {

    @Autowired
    private EnseignantRepo repo;

    @GetMapping("/")
    public List<Enseignant> getAllTeachers(){

        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Enseignant> getTeacher(@PathVariable String id){

        return repo.findById(id);
    }

    @PostMapping("/add")
    public Enseignant addTeacher(@RequestBody Enseignant e){

        return repo.save(e);
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
