package com.example.subjects.controller;

import com.example.subjects.model.dtos.SubjectDto;
import com.example.subjects.service.SubjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/subjects")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4201"})
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        try{
            return ResponseEntity.ok(subjectService.getAll());
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubjectDto> get(@PathVariable String id) {
        try{
            return ResponseEntity.ok(subjectService.get(id));
        }catch (Exception e){
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping
    public ResponseEntity<SubjectDto> create(@RequestBody SubjectDto subject) {
        try{
            return ResponseEntity.ok(subjectService.create(subject));
        }catch (Exception e){
            return ResponseEntity.status(500).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubjectDto> update(@PathVariable String id, @RequestBody SubjectDto subject) {
        try{
            return ResponseEntity.ok(subjectService.update(id, subject));
        }catch (Exception e){
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        try{
            subjectService.delete(id);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.status(500).build();
        }
    }
}
