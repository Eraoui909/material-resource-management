package com.example.micro_enseignant.Controller;

import com.example.micro_enseignant.models.Enseignant;
import com.example.micro_enseignant.repository.EnseignantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/teachers")
public class EnseignantController {

    @Autowired
    private EnseignantRepo repo;

    @GetMapping("/{id}")
    public Optional<Enseignant> getenseignantbyid(@PathVariable String id){
        return repo.findById(id);
    }

}
