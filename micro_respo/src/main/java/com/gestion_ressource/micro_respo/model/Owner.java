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
@Document(collection = "enseignant")
@Setter
@Getter
public class Owner {
    @Id
    private String id;

    @NotBlank
    private String name;

    private  String laboratoire;

    public Owner(String id, String name, String laboratoire) {
        this.id = id;
        this.name = name;
        this.laboratoire = laboratoire;
    }
}
