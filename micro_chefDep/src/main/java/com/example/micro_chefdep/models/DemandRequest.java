package com.example.micro_chefdep.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document(collection = "demandRequests")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DemandRequest {

    @Id
    private String id;
    private String sender;
    private String department;
    private Set<String> users;



}
