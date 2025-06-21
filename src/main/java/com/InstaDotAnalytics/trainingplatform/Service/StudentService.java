package com.InstaDotAnalytics.trainingplatform.Service;


import com.InstaDotAnalytics.trainingplatform.Dto.StudentRequestDTO;
import com.InstaDotAnalytics.trainingplatform.Model.Batch;
import com.InstaDotAnalytics.trainingplatform.Model.Student;

public interface StudentService {
    Student addStudent(StudentRequestDTO dto);
    Batch recommendBatchForStudent(Long studentId);

}

