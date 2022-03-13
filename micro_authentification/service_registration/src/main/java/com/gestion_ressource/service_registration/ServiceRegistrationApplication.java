package com.gestion_ressource.service_registration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ServiceRegistrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceRegistrationApplication.class, args);
    }

}
