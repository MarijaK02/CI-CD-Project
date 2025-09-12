package com.example.subjects.model.dtos;

import lombok.Data;

@Data
public class SubjectDto {
    private String id;
    private String name;
    private String description;
    private int credits;

    public SubjectDto() {
    }

    public SubjectDto(String id, String name, String description, int credits) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.credits = credits;
    }
}
