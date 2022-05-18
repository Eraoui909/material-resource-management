package com.example.micro_respomaintenanceee.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Document(collection = "resources")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Resource {
    @Id
    private String id;

    @NotBlank
    private String provider;

    @NotBlank
    private String marque;

    private String speed;

    private String resolution;

    private String CPU;

    private String hardDisk;

    private String RAM;

    private String screen;

    @NotBlank
    private String warrantyPeriod;

    private Owner affectedToOwner;

    private String affectedToDepartment;

    @NotBlank
    private String Date;

    private Panne panne;

}
