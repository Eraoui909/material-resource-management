package com.example.micro_respomaintenanceee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MicroRespoMaintenanceeeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroRespoMaintenanceeeApplication.class, args);
    }

}
