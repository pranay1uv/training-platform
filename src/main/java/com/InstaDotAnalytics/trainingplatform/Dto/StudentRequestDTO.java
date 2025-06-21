package com.InstaDotAnalytics.trainingplatform.Dto;


import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentRequestDTO {
    private String name;
    private String email;
    private String phone;
    private LocalDate dateOfBirth;
    private String appliedSubject;
    private List<String> previousCourses;
}
