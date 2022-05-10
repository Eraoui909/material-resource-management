package com.admin.admin.services;

import com.admin.admin.models.Enseignant;
import com.admin.admin.repositries.EnseignantRepo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class EnseignantService {

    private final WebClient webClient;
    @Autowired
    private EnseignantRepo enseignantRepo;


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
    @Transactional
    public Enseignant updateTeacherService(Enseignant e){

        Enseignant en = enseignantRepo.findEnseignantsByEmail(e.getEmail()).orElseThrow(()-> new IllegalStateException("enseignant doesnt exist"));
        en.setEmail(e.getEmail());

        return en;
    }

}
