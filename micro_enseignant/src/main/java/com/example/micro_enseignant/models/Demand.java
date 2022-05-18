package com.example.micro_enseignant.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Document(collection = "demands")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Demand {

    @Id
    private String id;
    private String sender;
    private String department;
    private String status = "Sent";
    private List<DemandEntity> resources = new ArrayList<>();
    private String date = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now());

}
