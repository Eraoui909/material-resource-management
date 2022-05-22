package com.gestion_ressource.micro_respo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Document(collection = "users")
@Setter
@Getter
@ToString
public class Provider {
    @Id
    private String id;

    @NotBlank
    private String username;

    @NotBlank
    private String name;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String phone;

    @NotBlank
    private String address;

    private List<Offer> offers;


    private String price;

    @NotBlank
    private Set<Role> authorities = new HashSet<Role>();







}
