package com.example.subjects.service;

import com.example.subjects.model.Subject;
import com.example.subjects.model.dtos.SubjectDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SubjectService {
    // Define service methods here
    List<SubjectDto> getAll();
    SubjectDto get(String id);
    SubjectDto create(SubjectDto subjectDto);
    SubjectDto update(String id, SubjectDto subjectDto);
    void delete(String id);
}
