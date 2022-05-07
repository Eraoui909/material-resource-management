package com.admin.admin.models;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Data @ToString
@Document(collection = "users")
public class Administrative {
    @Id
    private String id;

    @NotBlank
    private String name;

    @NotBlank
    private String username;

    @NotBlank
    private  String password;

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

    private Set<String> roles = Set.of("administrative");
}
