package com.example.micro_provider.models;

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


    @NotBlank
    private String warrantyPeriod;

    private Provider affectedToProvider;

    private String affectedToDepartment;

    @NotBlank
    private String Date;

    @NotBlank
    private Boolean signaler = false;

}
