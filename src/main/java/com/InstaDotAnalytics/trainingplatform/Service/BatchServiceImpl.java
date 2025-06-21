package com.InstaDotAnalytics.trainingplatform.Service;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.InstaDotAnalytics.trainingplatform.Dto.BatchRequestDTO;
import com.InstaDotAnalytics.trainingplatform.Exception.ResourceNotFoundException;
import com.InstaDotAnalytics.trainingplatform.Model.Batch;
import com.InstaDotAnalytics.trainingplatform.Model.Trainer;
import com.InstaDotAnalytics.trainingplatform.Repository.BatchRepository;
import com.InstaDotAnalytics.trainingplatform.Repository.TrainerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BatchServiceImpl implements BatchService {

    private final BatchRepository batchRepository;
    private final TrainerRepository trainerRepository;

    @Override
    public Batch addBatch(BatchRequestDTO dto) {
        Batch batch = Batch.builder()
                .title(dto.getTitle())
                .subject(dto.getSubject())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .maxCapacity(dto.getMaxCapacity())
                .enrolledStudents(new ArrayList<>())  // Initialize empty list
                .build();

        return batchRepository.save(batch);
    }

    @Override
    public List<Batch> getBatchesBySubject(String subject) {
        return batchRepository.findAll().stream()
                .filter(b -> b.getSubject().equalsIgnoreCase(subject))
                .collect(Collectors.toList());
    }

    @Override
    public Batch assignTrainerToBatch(Long batchId) {
        Batch batch = batchRepository.findById(batchId)
                .orElseThrow(() -> new ResourceNotFoundException("Batch not found with ID: " + batchId));

        List<Trainer> eligible = trainerRepository.findAll().stream()
                .filter(trainer -> trainer.getSubjectExpertise().contains(batch.getSubject()))
                .filter(trainer -> isAvailable(trainer, batch.getStartDate(), batch.getEndDate()))
                .sorted(Comparator.comparingDouble(Trainer::getRating).reversed()) // Highest rating first
                .collect(Collectors.toList());

        if (eligible.isEmpty()) {
            throw new RuntimeException("No suitable trainer available for this batch.");
        }

        batch.setAssignedTrainer(eligible.get(0));
        return batchRepository.save(batch);
    }

    private boolean isAvailable(Trainer trainer, LocalDate batchStart, LocalDate batchEnd) {
        return trainer.getAvailabilityPeriods().stream().anyMatch(period ->
                (batchStart.isAfter(period.getStartDate().minusDays(1)) &&
                 batchEnd.isBefore(period.getEndDate().plusDays(1)))
        );
    }
}
