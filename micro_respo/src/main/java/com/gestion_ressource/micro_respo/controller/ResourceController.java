package com.gestion_ressource.micro_respo.controller;

import com.gestion_ressource.micro_respo.model.Resource;
import com.gestion_ressource.micro_respo.repository.ResourceRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/resources")
@Slf4j
public class ResourceController {

    @Autowired
    private ResourceRepo resourceRepo;


    @GetMapping("/{username}")
    public List<Resource> getAll(@PathVariable String username){

        return resourceRepo.getResourcesByOwnerUsername(username);
    }

}
