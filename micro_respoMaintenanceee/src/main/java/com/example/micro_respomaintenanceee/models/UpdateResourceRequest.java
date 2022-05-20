package com.example.micro_respomaintenanceee.models;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class UpdateResourceRequest {
    private String id;
    private String commentaire;
}
