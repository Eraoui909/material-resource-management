package com.example.micro_chefdep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MicroChefDepApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroChefDepApplication.class, args);
    }

}
