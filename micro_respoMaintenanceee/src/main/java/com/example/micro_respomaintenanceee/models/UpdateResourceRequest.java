package com.example.micro_respomaintenanceee.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@NoArgsConstructor
@Setter
@Getter
public class UpdateResourceRequest {
    private String id;
    private String commentaire;
    private String etat;
}
