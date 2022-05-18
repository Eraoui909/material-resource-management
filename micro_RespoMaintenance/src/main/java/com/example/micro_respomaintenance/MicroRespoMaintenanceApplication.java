package com.example.micro_respomaintenance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MicroRespoMaintenanceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroRespoMaintenanceApplication.class, args);
    }

}
