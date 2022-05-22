package com.example.micro_respomaintenanceee.controller;

import com.example.micro_respomaintenanceee.models.Panne;
import com.example.micro_respomaintenanceee.models.Resource;
import com.example.micro_respomaintenanceee.models.UpdateResourceRequest;
import com.example.micro_respomaintenanceee.repo.RepoRessource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.POST;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/maintenance")

public class RespoMainteController {

    @Autowired
    RepoRessource ressource;

    @GetMapping
    public List<Resource> afficherpanne(){
        return ressource.findAll();
    }

    @PostMapping("/envoeyerconstat")
    public Resource update(@RequestBody UpdateResourceRequest request){
        Resource res = ressource.findById(request.getId()).get();
        Panne panne = res.getPanne();
        panne.setCommentaire(request.getCommentaire());
        panne.setEtats(request.getEtat());
        res.setPanne(panne);
        return ressource.save(res);
    }

}
