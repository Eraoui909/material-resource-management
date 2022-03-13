package com.gestion_ressource.micro_authentification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MicroAuthentificationApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroAuthentificationApplication.class, args);
    }

}
