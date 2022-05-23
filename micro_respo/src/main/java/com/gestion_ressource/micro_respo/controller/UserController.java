package com.gestion_ressource.micro_respo.controller;

import com.gestion_ressource.micro_respo.model.User;
import com.gestion_ressource.micro_respo.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/profile")
@Slf4j
public class UserController {

    @Autowired
    private UserRepo repo;

    @PostMapping("/update")
    public User update(@RequestBody User user){
        log.info(user.getId());
        Optional<User> user1 = repo.findById(user.getId());
        user.setAuthorities(user1.get().getAuthorities());
        user.setPassword(user1.get().getPassword());
        return repo.save(user);
//        return user;
    }
    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping("/users")
    public List<User> findAll(){
        return repo.findAll();
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @PostMapping("/setEliminated/{id}")
    public String setEliminated(@PathVariable String id){
        User u = repo.findById(id).orElseThrow();
        u.setStatus("eliminated");
        repo.save(u);
        return "success";
    }

    @GetMapping("/{id}")
    public Optional<User> getById(@PathVariable String id){
        return repo.findById(id);
    }

}