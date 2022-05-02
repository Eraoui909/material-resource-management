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
public class MicroAuthentificationApplication {

    @Autowired
    RoleRepository repository;
    public static void main(String[] args) {
        SpringApplication.run(MicroAuthentificationApplication.class, args);
    }
}
