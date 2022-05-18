package com.admin.admin.controllers;

import com.admin.admin.models.ERole;
import com.admin.admin.models.Enseignant;
import com.admin.admin.models.Role;
import com.admin.admin.models.User;
import com.admin.admin.repositries.EnseignantRepo;
import com.admin.admin.repositries.UserRepo;
import com.admin.admin.services.EnseignantService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/teachers")
public class EnseignantController {


    @Autowired
    private EnseignantService enseignantService;

    @Autowired
    private UserRepo repo;

    @Autowired
    EnseignantRepo enseignantRepo;



    @GetMapping("/")
    public List<Enseignant> getAllTeachers() {

        return enseignantRepo.findEnseignants();

    }

    @GetMapping("/{id}")
    public Enseignant getTeacher(@PathVariable String id){

        return enseignantRepo.findEnseignantsById(id);
    }

    @GetMapping("/department/{name}")
    public List<User> getByDepartment(@PathVariable String name){
        return repo.findByDepartment(name);
    }

    @PostMapping("/add") @JsonIgnore
    public Enseignant addTeacher(@RequestBody Enseignant e){
        e.setPassword(e.getEmail());
        e.setUsername(e.getEmail());
        System.err.println(e.toString());
        enseignantService.addEnseignant(e);

        return e;
    }

    @PostMapping("/update")
//<<<<<<< HEAD
//<<<<<<< HEAD
//    @Transactional
    public User updateTeacher(@RequestBody User e) {

        return repo.save(e);
//=======
//    public Enseignant updateTeacher(@RequestBody Enseignant e){
//        return enseignantService.updateTeacherService(e);
//>>>>>>> c32f328d9297d960df41b038b258ea4e1d2bd661
    }
//=======
//    public Enseignant updateTeacher(@RequestBody Enseignant e){
//
//        Enseignant en = enseignantRepo.findEnseignantsByEmail(e.getEmail()).orElseThrow(()-> new IllegalStateException("enseignant doesnt exist"));
//        en.setEmail(e.getEmail());
//
//        return en;
//    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable String id){
        repo.deleteById(id);
    }



}
