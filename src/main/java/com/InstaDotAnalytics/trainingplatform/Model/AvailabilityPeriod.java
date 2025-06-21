package com.InstaDotAnalytics.trainingplatform.Model;


import java.time.LocalDate;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvailabilityPeriod {
    private LocalDate startDate;
    private LocalDate endDate;
}
