package com.InstaDotAnalytics.trainingplatform.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.InstaDotAnalytics.trainingplatform.Dto.StudentRequestDTO;
import com.InstaDotAnalytics.trainingplatform.Model.Batch;
import com.InstaDotAnalytics.trainingplatform.Model.Student;
import com.InstaDotAnalytics.trainingplatform.Service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public Student addStudent(@Valid @RequestBody StudentRequestDTO dto) {
        return studentService.addStudent(dto);
    }
    
    @GetMapping("/{studentId}/recommend-batch")
    public ResponseEntity<Batch> recommendBatch(@PathVariable Long studentId) {
        Batch recommended = studentService.recommendBatchForStudent(studentId);
        return ResponseEntity.ok(recommended);
    }
}

