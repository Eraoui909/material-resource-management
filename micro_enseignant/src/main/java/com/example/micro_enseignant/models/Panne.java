package com.example.micro_enseignant.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "pannes")
public class Panne {

    String dateAppartition;
    String explicationPanne;
    String frequencePanne;
    String ordrePanne;
    String declaredBy;

}
