package com.example.micro_chefdep.controllers;

import com.example.micro_chefdep.Services.ChefDepService;
import com.example.micro_chefdep.models.*;
import com.example.micro_chefdep.repositories.DemandRepo;
import com.example.micro_chefdep.repositories.DemandRequestRepo;
import com.example.micro_chefdep.repositories.EnseignantRepo;
import com.example.micro_chefdep.repositories.FinalDemandRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/chefDepartement")
public class ChefDepController {

    private ChefDepService chefDepService;
    private EnseignantRepo enseignantRepo;

    @Autowired
    private DemandRequestRepo demandRequestRepo;

    @Autowired
    private DemandRepo demandRepo;

    @Autowired
    private FinalDemandRepo finalDemandRepo;

    @GetMapping(path = "teachers/{depID}")
    public List<Enseignant> getTeachers(@PathVariable("depID") String id){
        List<Enseignant> en = new ArrayList<>();
        en.add(new Enseignant("hanza baroudi","hamza@gmail.com","0612547878","FES","INFO"));
        en.add(new Enseignant("achraf zaim","achraf@gmail.com","065454578","RABAT","MATH"));
        en.add(new Enseignant("hamza eraoui","eraoui@gmail.com","0645487518","Sefrou","CHIMIE"));
        en.add(new Enseignant("ayoub amazyan","ayoub@gmail.co;","0611497548","Hoceima","MECA"));
        return en;
        //return enseignantRepo.findEnseignantsByDepartement(id);
    }


    @PostMapping(path = "update/{chefDepID}")
    public void updateChefDep(@PathVariable("chefDepID") String id, @RequestBody ChefDep chefDep){
        chefDepService.updateChefDep(id, chefDep);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)    @PostMapping(path = "availableBudget")
    public DemandRequest availableBudget(@RequestBody DemandRequest Demand){
        return demandRequestRepo.save(Demand);
    }

    @GetMapping("/resources-requests")
    public List<Demand> getAllRequests() {
        return demandRepo.findAll();
    }

    @PostMapping("/sendDemand")
    @CrossOrigin(origins = "*", maxAge = 3600)
    public FinalDemand sendDemand(@RequestBody FinalDemand demand) {
        return finalDemandRepo.save(demand);
    }

    @GetMapping("/sent-requests")
    public List<FinalDemand> getAllSentRequests() {
        return finalDemandRepo.findAll();
    }
}
