package com.InstaDotAnalytics.trainingplatform.Service;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.InstaDotAnalytics.trainingplatform.Dto.StudentRequestDTO;
import com.InstaDotAnalytics.trainingplatform.Exception.ResourceNotFoundException;
import com.InstaDotAnalytics.trainingplatform.Model.Batch;
import com.InstaDotAnalytics.trainingplatform.Model.Student;
import com.InstaDotAnalytics.trainingplatform.Repository.BatchRepository;
import com.InstaDotAnalytics.trainingplatform.Repository.StudentRepository;



@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private BatchRepository batchRepository;

    @Override
    public Student addStudent(StudentRequestDTO dto) {
        Student student = Student.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .dateOfBirth(dto.getDateOfBirth())
                .appliedSubject(dto.getAppliedSubject())
                .previousCourses(dto.getPreviousCourses() != null ? dto.getPreviousCourses() : new ArrayList<>())
                .build();

        return studentRepository.save(student);
    }

	@Override
	public Batch recommendBatchForStudent(Long studentId) {
		// TODO Auto-generated method stub
		Student student = studentRepository.findById(studentId)
		        .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

		    List<Batch> matchingBatches = batchRepository.findAll().stream()
		        .filter(batch -> batch.getSubject().equalsIgnoreCase(student.getAppliedSubject()))
		        .filter(batch -> batch.getStartDate().isAfter(LocalDate.now()))
		        .sorted(Comparator.comparing(batch -> batch.getStartDate()))
		        .collect(Collectors.toList());

		    // Optional: add preference score logic
		    Batch bestMatch = null;
		    int maxScore = -1;

		    for (Batch batch : matchingBatches) {
		        int score = 0;
		        for (String course : student.getPreviousCourses()) {
		            if (course.equalsIgnoreCase(batch.getSubject())) {
		                score += 10;
		            }
		        }
		        // Prioritize closest upcoming start date
		        score += 5 / (1 + ChronoUnit.DAYS.between(LocalDate.now(), batch.getStartDate()));

		        if (score > maxScore) {
		            maxScore = score;
		            bestMatch = batch;
		        }
		    }

		    if (bestMatch == null) {
		        throw new RuntimeException("No matching batch found for student.");
		    }

		    return bestMatch;
	}
}
