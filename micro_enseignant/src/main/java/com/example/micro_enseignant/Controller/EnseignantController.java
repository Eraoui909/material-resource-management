package com.example.micro_enseignant.Controller;

import com.example.micro_enseignant.models.EState;
import com.example.micro_enseignant.models.Enseignant;
import com.example.micro_enseignant.models.Panne;
import com.example.micro_enseignant.repository.EnseignantRepo;
import com.example.micro_enseignant.repository.PanneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/teachers")
public class EnseignantController {

    @Autowired
    private EnseignantRepo repo;

    @Autowired
    private PanneRepo panneRepo;

    @GetMapping("/{id}")
    public Optional<Enseignant> getenseignantbyid(@PathVariable String id){
        return repo.findById(id);
    }

    @PostMapping("/signalerPanne")
    public Panne signalerPanne(@RequestBody Panne panne){
        panne.setEtats(EState.ENCOURS);
        return panneRepo.save(panne);
    }

}
