package com.gestion_ressource.proxy.config;

import com.gestion_ressource.proxy.filter.AuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Autowired
    private AuthFilter filter;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("authentification", r -> r.path("/auth/**").uri("http://localhost:8081/"))
                .route("test", r -> r.path("/test/**").filters(f -> f.filter(filter)).uri("http://localhost:8082/"))
                .build();
    }
}