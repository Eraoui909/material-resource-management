package com.admin.admin.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.RestController;

@Data
@Document(collection = "departments")
public class Department {


    @Id
    private String id;

    private String name;

    private String chef_dep_name;

    private String chef_dep_email;

    private String chef_dep_id;
}
