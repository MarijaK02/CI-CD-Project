package com.example.subjects.service.impl;

import com.example.subjects.model.Subject;
import com.example.subjects.model.dtos.SubjectDto;
import com.example.subjects.repository.SubjectRepository;
import com.example.subjects.service.SubjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    private final SubjectRepository subjectRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public List<SubjectDto> getAll() {
        return subjectRepository.findAll().stream().map(subject -> new SubjectDto(
                subject.getId(),
                subject.getName(),
                subject.getDescription(),
                subject.getCredits()
        )).toList();
    }

    @Override
    public SubjectDto get(String id) {
        return subjectRepository.findById(id).map(subject -> new SubjectDto(
                subject.getId(),
                subject.getName(),
                subject.getDescription(),
                subject.getCredits()
        )).orElseThrow(() -> new RuntimeException("Subject not found"));
    }

    @Override
    public SubjectDto create(SubjectDto subjectDto) {
        Subject subject = new Subject();

        subject.setName(subjectDto.getName());
        subject.setDescription(subjectDto.getDescription());
        subject.setCredits(subjectDto.getCredits());

        Subject savedSubject = subjectRepository.save(subject);
        return new SubjectDto(
                savedSubject.getId(),
                savedSubject.getName(),
                savedSubject.getDescription(),
                savedSubject.getCredits()
        );
    }

    @Override
    public SubjectDto update(String id, SubjectDto subjectDto) {
        Subject subject = subjectRepository.findById(id).orElseThrow(() -> new RuntimeException("Subject not found"));

        subject.setName(subjectDto.getName());
        subject.setDescription(subjectDto.getDescription());
        subject.setCredits(subjectDto.getCredits());

        Subject newSubject = subjectRepository.save(subject);
        return new SubjectDto(
                newSubject.getId(),
                newSubject.getName(),
                newSubject.getDescription(),
                newSubject.getCredits()
        );
    }

    @Override
    public void delete(String id) {
        subjectRepository.deleteById(id);
    }
}
