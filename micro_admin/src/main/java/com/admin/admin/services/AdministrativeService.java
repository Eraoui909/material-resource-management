package com.admin.admin.services;

import com.admin.admin.models.Administrative;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class AdministrativeService {

    private final WebClient webClient1;

    public AdministrativeService(WebClient.Builder builder) {
        this.webClient1 = builder.baseUrl("http://localhost:8081").build();
    }

    @JsonIgnore
    public Administrative addAdministrative(Administrative e){

        try{
            return webClient1.post().uri("/auth/register")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .body(Mono.just(e), Administrative.class)
                    .retrieve()
                    .bodyToMono(Administrative.class)
                    .block();

        }catch (Exception ee){
            return e;
        }

    }

}

