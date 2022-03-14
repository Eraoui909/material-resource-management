package com.gestion_ressource.micro_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MicroTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroTestApplication.class, args);
    }

}
