package com.admin.admin.controllers;

import com.admin.admin.models.Administrative;
import com.admin.admin.repositries.AdministrativeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/administrative")
public class AdministrativeController {

    @Autowired
    private AdministrativeRepo repo;

    @GetMapping("/")
    public List<Administrative> getAlladministative(){
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Administrative> getAdministrativeById(@PathVariable String id){
        return repo.findById(id);
    }

    @PostMapping("/add")
    public Administrative addAdministrative(@RequestBody Administrative a){
        return repo.save(a);
    }

    @PostMapping("/update")
    public Administrative updateAdministrative(@RequestBody Administrative e){
        return repo.save(e);
    }

    @DeleteMapping("/{id}")
    public void deleteAdministrative(@PathVariable String id){
        repo.deleteById(id);
    }
}
