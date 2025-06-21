package com.InstaDotAnalytics.trainingplatform.Dto;


import java.util.List;

import com.InstaDotAnalytics.trainingplatform.Model.AvailabilityPeriod;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrainerRequestDTO {
    private String name;
    private String email;
    private List<String> subjectExpertise;
    private double rating;
    private List<AvailabilityPeriod> availabilityPeriods;
}
