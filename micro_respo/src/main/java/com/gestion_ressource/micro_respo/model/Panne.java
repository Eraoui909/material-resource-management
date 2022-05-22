package com.gestion_ressource.micro_respo.model;

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
    private String etats = String.valueOf(EState.ENCOURS);

}
