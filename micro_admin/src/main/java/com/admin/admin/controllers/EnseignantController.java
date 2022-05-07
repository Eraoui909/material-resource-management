package com.admin.admin.controllers;

import com.admin.admin.models.ERole;
import com.admin.admin.models.Enseignant;
import com.admin.admin.models.Role;
import com.admin.admin.models.User;
import com.admin.admin.repositries.UserRepo;
import com.admin.admin.services.EnseignantService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
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



    @GetMapping("/")
    public List<User> getAllTeachers(){
        Set<Role> authorities = new HashSet<>();
        authorities.add(new Role(ERole.ROLE_ADMIN));
        return repo.findByAuthorities(authorities);
    }

    @GetMapping("/{id}")
    public Optional<User> getTeacher(@PathVariable String id){

        return repo.findById(id);
    }

    @GetMapping("/laboratoire/{name}")
    public List<User> getByLaboratoire(@PathVariable String name){
        return repo.findByLaboratory(name);
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
    public User updateTeacher(@RequestBody User e){

        return repo.save(e);
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable String id){
        repo.deleteById(id);
    }



}
