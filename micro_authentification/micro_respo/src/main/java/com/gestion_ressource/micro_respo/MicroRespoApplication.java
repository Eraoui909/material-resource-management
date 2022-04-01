package com.gestion_ressource.micro_respo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MicroRespoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroRespoApplication.class, args);
    }

}
