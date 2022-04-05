package com.example.micro_chefdep.controllers;

import com.example.micro_chefdep.Services.ChefDepService;
import com.example.micro_chefdep.models.ChefDep;
import com.example.micro_chefdep.repositories.ChefDefRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/chefDepartement")
public class ChefDepController {

    private ChefDepService chefDepService;

    @PutMapping(path = "update/{chefDepID}")
    public void updateChefDep(@PathVariable("chefDepID") String id, @RequestBody ChefDep chefDep){
        chefDepService.updateChefDep(id, chefDep);
    }
}
