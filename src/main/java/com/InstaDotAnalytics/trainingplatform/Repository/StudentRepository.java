package com.InstaDotAnalytics.trainingplatform.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.InstaDotAnalytics.trainingplatform.Model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
}

