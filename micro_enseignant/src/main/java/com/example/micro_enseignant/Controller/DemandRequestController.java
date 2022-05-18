package com.example.micro_enseignant.Controller;

import com.example.micro_enseignant.models.Demand;
import com.example.micro_enseignant.models.DemandRequest;
import com.example.micro_enseignant.repository.DemandRepo;
import com.example.micro_enseignant.repository.DemandRequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/demands")
public class DemandRequestController {

    @Autowired
    private DemandRequestRepo demandRequestRepo;

    @Autowired
    private DemandRepo demandRepo;

    @GetMapping("/{dep}")
    public Optional<DemandRequest> getDemandRequests(@PathVariable String dep){
        DemandRequest demand = demandRequestRepo.findFirstByDepartmentOrderByIdDesc(dep);
            return Optional.of(demand);
    }

    @PostMapping("/changeState/{user}/{demand}")
    public DemandRequest changeState(@PathVariable String user, @PathVariable String demand) throws Exception {
        DemandRequest dem = demandRequestRepo.findById(demand).orElseThrow(() -> new Exception("Bad ID"));
        Set<String> users = new HashSet<String>(dem.getUsers());
        users.add(user);
        dem.setUsers(users);
        return demandRequestRepo.save(dem);
    }

    @PostMapping("/sendDemand")
    public Demand sendDemand(@RequestBody Demand demand) {
        return demandRepo.save(demand);
    }

    @GetMapping("/MyDemands/{user}")
    public List<Demand> getDemands(@PathVariable String user) {
        return demandRepo.findAllBySenderOrderByIdDesc(user);
    }


}
