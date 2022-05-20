package com.example.micro_respomaintenanceee.models;

import lombok.Data;

@Data
public class Panne {
    private String id;
    private String dateAppartition;
    private String explicationPanne;
    private String frequencePanne;
    private String ordrePanne;
    private String declaredBy;
    private String commentaire;
    private EState etats = EState.ENCOURS;

}
