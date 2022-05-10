package com.gestion_ressource.micro_respo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Document(collection = "users")
@Setter
@Getter
public class Owner {
    @Id
    private String id;

    private String username;

    private  String department;




    public Owner(String id, String username, String department) {
        this.id = id;
        this.username = username;
        this.department = department;
    }
}
