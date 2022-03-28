package com.example.micro_enseignant.Controller;

import com.example.micro_enseignant.modales.Enseignant;
import com.example.micro_enseignant.repository.EnseignantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/Teachers")
public class EnseignantController {

    @Autowired
    private EnseignantRepo repo;

    @PostMapping("/")
    public void save(@RequestBody Enseignant enseignant){
        repo.save(enseignant);
    }

    @GetMapping("/")
    public List<Enseignant> getenseignant(){
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Enseignant> getenseignantbyid(@PathVariable String id){
        return repo.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteenseignant(@PathVariable String id){
        repo.deleteById(id);
    }

}
