package com.admin.admin.controllers;

import com.admin.admin.models.Department;
import com.admin.admin.repositries.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 200)
@RestController
@RequestMapping("/departments")
public class DepartmentController {


    @Autowired
    private DepartmentRepo repo;

    @GetMapping("/")
    public List<Department> getAllDepartments(){

        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Department> getDepartment(@PathVariable String id){

        return repo.findById(id);
    }

    @PostMapping("/add")
    public Department addDepartment(@RequestBody Department e){

        return repo.save(e);
    }

    @PostMapping("/update")
    public Department updateDepartment(@RequestBody Department e){

        return repo.save(e);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable String id){
        repo.deleteById(id);
    }

}
