package com.admin.admin.services;

import com.admin.admin.models.Enseignant;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class EnseignantService {

    private final WebClient webClient;

    public EnseignantService(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("http://localhost:8080").build();
    }

    @JsonIgnore
    public Enseignant addEnseignant(Enseignant e){

        try{
            return webClient.post().uri("/auth/register")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .body(Mono.just(e), Enseignant.class)
                    .retrieve()
                    .bodyToMono(Enseignant.class)
                    .block();

        }catch (Exception ee){
            return e;
        }

    }

}
