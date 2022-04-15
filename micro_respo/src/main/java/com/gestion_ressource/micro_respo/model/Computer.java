package com.gestion_ressource.micro_respo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import javax.validation.constraints.NotBlank;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "computers")
@NoArgsConstructor
@Getter
@Setter
public class Computer {
    @Id
    private String id;

    @NotBlank
    private String provider;

    @NotBlank
    private String marque;

    @NotBlank
    private String CPU;

    @NotBlank
    private String hardDisk;

    @NotBlank
    private String screen;

    @NotBlank
    private String warrantyPeriod;

    private Owner affectedTo;

    @NotBlank
    private String Date;
}

