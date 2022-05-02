package com.admin.admin.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Data
@Document(collection = "users")
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
    private  String laboratoire;
}
