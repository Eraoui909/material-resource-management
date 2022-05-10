package com.example.micro_respomaintenance.controller;

import com.example.micro_respomaintenance.models.Panne;
import com.example.micro_respomaintenance.repo.PanneRepo;
import com.example.micro_respomaintenance.repo.RepoMaintenance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/RespoMaintenance")

public class RespoMainteController {
//    @Autowired
    RepoMaintenance maintenance;

    @Autowired
    PanneRepo panne;

    @GetMapping("/Pannes")
    public List<Panne> afficherpanne(){
        return panne.findAll();
    }

}
