package com.gestion_ressource.micro_respo.controller;

import com.gestion_ressource.micro_respo.model.Printer;
import com.gestion_ressource.micro_respo.repository.PrinterRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/printers")
@Slf4j
public class PrinterController {

    @Autowired
    private PrinterRepository repo;

    @PostMapping("/add")
    public void save(@RequestBody Printer printer){
        repo.save(printer);
    }

    @PostMapping("/update")
    public void update(@RequestBody Printer printer){
        repo.save(printer);
    }

    @GetMapping("/")
    public List<Printer> getAll(){
        return repo.getAllPrinters();
    }

    @GetMapping("/{id}")
    public Optional<Printer> getById(@PathVariable String id){
        return repo.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id){
        repo.deleteById(id);
    }

}