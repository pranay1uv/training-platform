package com.InstaDotAnalytics.trainingplatform.Dto;


import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BatchRequestDTO {
    private String title;
    private String subject;
    private LocalDate startDate;
    private LocalDate endDate;
    private int maxCapacity;
}
