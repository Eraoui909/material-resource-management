package com.example.micro_chefdep.controllers;

import com.example.micro_chefdep.models.MemberProfile;
import com.example.micro_chefdep.repositories.MemberProfileRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/profile")
@Slf4j
public class Profile {
    @Autowired
    private MemberProfileRepo repo;

    @PostMapping("/update")
    public MemberProfile update(@RequestBody MemberProfile member){
        log.info(member.getId());
        Optional<MemberProfile> user1 = repo.findById(member.getId());
        member.setAuthorities(user1.get().getAuthorities());
        member.setPassword(user1.get().getPassword());
        return repo.save(member);
//        return user;
    }

    @GetMapping("/{id}")
    public Optional<MemberProfile> getById(@PathVariable String id){
        return repo.findById(id);
    }

    @GetMapping("/")
    public List<MemberProfile> getAll(){
        return repo.findAll();
    }
}
