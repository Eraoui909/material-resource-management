package com.example.micro_chefdep.controllers;

import com.example.micro_chefdep.Services.ChefDepService;
import com.example.micro_chefdep.models.ChefDep;
import com.example.micro_chefdep.models.Enseignant;
import com.example.micro_chefdep.repositories.EnseignantRepo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/chefDepartement")
public class ChefDepController {

    private ChefDepService chefDepService;
    private EnseignantRepo enseignantRepo;

    @GetMapping(path = "teachers/{depID}")
    public List<Enseignant> getTeachers(@PathVariable("depID") String id){
        List<Enseignant> en = new ArrayList<>();
        en.add(new Enseignant("hanza baroudi","hamza@gmail.com","0612547878","FES","INFO"));
        en.add(new Enseignant("achraf zaim","achraf@gmail.com","065454578","RABAT","MATH"));
        en.add(new Enseignant("hamza eraoui","eraoui@gmail.com","0645487518","Sefrou","CHIMIE"));
        en.add(new Enseignant("ayoub amazyan","ayoub@gmail.co;","0612487548","fess","MECA"));
        return en;
        //return enseignantRepo.findEnseignantsByDepartement(id);
    }


    @PostMapping(path = "update/{chefDepID}")
    public void updateChefDep(@PathVariable("chefDepID") String id, @RequestBody ChefDep chefDep){
        chefDepService.updateChefDep(id, chefDep);
    }
}
