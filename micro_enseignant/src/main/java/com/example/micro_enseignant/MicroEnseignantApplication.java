package com.example.micro_enseignant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MicroEnseignantApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroEnseignantApplication.class, args);
    }

}
