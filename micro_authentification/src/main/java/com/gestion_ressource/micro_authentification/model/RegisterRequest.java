package com.gestion_ressource.micro_authentification.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
public class RegisterRequest {
    private String username;
    private String name;
    private String email;
    private String password;
    private String phone;
    private String address;
    private String laboratoire;
    private String department;
    private Set<String> roles;
}
