package com.gestion_ressource.micro_authentification;

import com.gestion_ressource.micro_authentification.model.ERole;
import com.gestion_ressource.micro_authentification.model.Role;
import com.gestion_ressource.micro_authentification.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MicroAuthentificationApplication implements CommandLineRunner {

    @Autowired
    RoleRepository repository;
    public static void main(String[] args) {
        SpringApplication.run(MicroAuthentificationApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {

//        repository.save(new Role(ERole.ROLE_Respo_Maint));
//        repository.save(new Role(ERole.ROLE_ADMINISTRATIVE));
//        repository.save(new Role(ERole.ROLE_Respo_Maint));
//        repository.save(new Role(ERole.ROLE_CHEF_DEP));
//        repository.save(new Role(ERole.ROLE_PROF));
//        repository.save(new Role(ERole.ROLE_CHEF_RESOURCES));
//        repository.save(new Role(ERole.ROLE_PROVIDER));
    }

}
