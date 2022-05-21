package com.example.micro_provider.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "roles")
@NoArgsConstructor
@Getter
@Setter
public class Role {
    @Id
    private String Id;
    private ERole name;

    public Role(ERole name) {
        this.name = name;
    }

}
