package com.admin.admin.controllers;

import com.admin.admin.models.Administrative;
import com.admin.admin.repositries.AdministrativeRepo;
import com.admin.admin.services.AdministrativeService;
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
    @Autowired
    private AdministrativeService administrativeService;

    @GetMapping("/")
    public List<Administrative> getAlladministative(){
        return repo.findAdministrative();
    }

    @GetMapping("/{id}")
    public Optional<Administrative> getAdministrativeById(@PathVariable String id){
        return repo.findById(id);
    }

    @PostMapping("/add")
    public Administrative addAdministrative(@RequestBody Administrative e){
        e.setId("54655644654");
        e.setPassword(e.getEmail());
        e.setUsername(e.getEmail());
        e.setLaboratoire("infooooooooo");
        System.err.println(e.toString());
        administrativeService.addAdministrative(e);

        return e;
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
