package com.gestion_ressource.micro_respo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Document(collection = "users")
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    private String id;

    @NotBlank
    private String username;

    @Email
    @NotBlank
    @Size(max = 60, min = 15)
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String phone;

    private String Address;

    private String name;

    private String status;

    private String laboratory;

    private String department;

    private Set<Role> authorities = new HashSet<Role>();

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
