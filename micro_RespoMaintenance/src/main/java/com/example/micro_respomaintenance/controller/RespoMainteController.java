package com.example.micro_respomaintenance.controller;

import com.example.micro_respomaintenance.models.Resource;
import com.example.micro_respomaintenance.repo.RepoRessource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/maintenance")

public class RespoMainteController {

    @Autowired
    RepoRessource ressource;

    @GetMapping
    public List<Resource> afficherpanne(){
        return ressource.getAllResources(null);
    }
}
