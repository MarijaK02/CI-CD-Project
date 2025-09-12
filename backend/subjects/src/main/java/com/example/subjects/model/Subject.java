package com.example.subjects.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "subjects")
@Setter
@Getter
public class Subject {
    @Id
    private String id;
    @Setter
    private String name;
    private String description;
    private int credits;

    public Subject() {}
    public Subject(String name, String description, int credits) {
        this.name = name;
        this.description = description;
        this.credits = credits;
    }
}
