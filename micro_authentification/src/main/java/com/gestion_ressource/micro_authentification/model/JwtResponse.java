package com.gestion_ressource.micro_authentification.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Component
public class JwtResponse {
    private String token;
    private String Id;
    private String username;
    private String email;
    private List<String> roles;
}
