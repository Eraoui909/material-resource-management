package com.example.micro_chefdep.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
@Document(collection = "enseignant")
public class Enseignant {
    @Id
    private String id;

    @NotBlank
    private String name;

    @NotBlank
    @Email
    @Size(max = 60, min = 15)
    private String email;

    @NotBlank
    private String phone;

    @NotBlank
    private String address;

    @NotBlank
    private String departement;

    public Enseignant(String name, String email, String phone, String address, String departement) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.departement = departement;
    }
}

