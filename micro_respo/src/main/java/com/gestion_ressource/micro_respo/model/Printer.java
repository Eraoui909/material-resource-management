package com.gestion_ressource.micro_respo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Document(collection = "resources")
@NoArgsConstructor
@Getter
@Setter
public class Printer {
    @Id
    private String id;

    @NotBlank
    private String provider;

    @NotBlank
    private String marque;

    @NotBlank
    private String speed;

    @NotBlank
    private String resolution;

    @NotBlank
    private String warrantyPeriod;

    private Owner affectedToOwner;

    private String affectedToDepartment;

    @NotBlank
    private String Date;
}

