package com.gestion_ressource.micro_respo.model;

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

@Document(collection = "offers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Offers {
    @Id
    private String id;
    private String title;
    private String description;
    private String status;
    private List<Resource> resources = new ArrayList<>();
    private String date = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now());
}
