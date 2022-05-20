package com.example.micro_chefdep.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "final_demands")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FinalDemand {

    @Id
    private String id;
    private String sender;
    private String department;
    private String status;
    private List<DemandEntity> resources = new ArrayList<>();
    private String date = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now());

}
