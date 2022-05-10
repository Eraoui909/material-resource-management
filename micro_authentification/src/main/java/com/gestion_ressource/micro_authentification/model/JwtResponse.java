package com.gestion_ressource.micro_authentification.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Component
public class JwtResponse {
    private String token;
    private String Id;
    private String username;
    private String name;
    private String email;
    private String phone;
    private String Address;
    private String Laboratory;
    private List<ERole> roles;

    public JwtResponse(String token, User user) {
        this.token = token;
        this.Id = user.getId();
        this.username = user.getUsername();
        this.name = user.getName();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.Address = user.getAddress();
        this.Laboratory = user.getLaboratoire();
        List<ERole> roles = user.getAuthorities().stream()
                .map(Role::getName)
                .collect(Collectors.toList()
                );
        this.roles = roles;
    }
}
