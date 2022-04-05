package com.example.micro_chefdep.controllers;

import com.example.micro_chefdep.Services.ChefDepService;
import com.example.micro_chefdep.models.ChefDep;
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
