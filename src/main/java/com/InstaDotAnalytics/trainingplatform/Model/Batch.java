package com.InstaDotAnalytics.trainingplatform.Model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Batch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String subject;
    private LocalDate startDate;
    private LocalDate endDate;
    private int maxCapacity;

    @ManyToOne
    private Trainer assignedTrainer;

    @OneToMany(mappedBy = "batch", cascade = CascadeType.ALL)
    private List<Student> enrolledStudents;
}
