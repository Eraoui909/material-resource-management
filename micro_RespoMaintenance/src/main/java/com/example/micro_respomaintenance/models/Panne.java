package com.example.micro_respomaintenance.models;

import lombok.Data;

@Data
public class Panne {
    private String id;
    private String dateAppartition;
    private String explicationPanne;
    private String frequencePanne;
    private String ordrePanne;
    private String declaredBy;
    private EState etats = EState.ENCOURS;

}
