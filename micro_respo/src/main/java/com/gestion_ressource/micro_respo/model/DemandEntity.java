package com.gestion_ressource.micro_respo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DemandEntity {
    private String Qte;
    private String CPU;
    private String RAM;
    private String marque;
    private String hardDisk;
    private String screen;
    private String speed;
    private String resolution;
}
