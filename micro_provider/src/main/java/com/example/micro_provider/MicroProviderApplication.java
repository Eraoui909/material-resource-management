package com.example.micro_provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MicroProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroProviderApplication.class, args);
    }

}
