package com.gestion_ressource.micro_respo.controller;

import com.gestion_ressource.micro_respo.model.Computer;
import com.gestion_ressource.micro_respo.repository.ComputerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/computers")
@Slf4j
public class ComputerController {

    @Autowired
    private ComputerRepository repo;

    @PostMapping("/add")
    public void save(@RequestBody Computer computer){
        System.err.println(computer.toString());

        repo.save(computer);
    }

    @PostMapping("/update")
    public void update(@RequestBody Computer computer){
        repo.save(computer);
    }

    @GetMapping("/")
    public List<Computer> getAll(){
        return repo.getAllComputers();
    }

    @GetMapping("/resources/teacher/{username}")
    public List<Computer> getAll(@PathVariable String username){
        return repo.getResourcesByOwnerUsername(username);
    }

    @GetMapping("/{id}")
    public Optional<Computer> getById(@PathVariable String id){
        log.info(id);
        return repo.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id){
        repo.deleteById(id);
    }

}