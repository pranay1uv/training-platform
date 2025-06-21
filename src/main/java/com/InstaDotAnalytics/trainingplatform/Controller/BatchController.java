package com.InstaDotAnalytics.trainingplatform.Controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.InstaDotAnalytics.trainingplatform.Dto.BatchRequestDTO;
import com.InstaDotAnalytics.trainingplatform.Model.Batch;
import com.InstaDotAnalytics.trainingplatform.Service.BatchService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/batches")
@RequiredArgsConstructor
public class BatchController {

    private final BatchService batchService;

    @PostMapping
    public ResponseEntity<Batch> addBatch(@Valid @RequestBody BatchRequestDTO dto) {
        Batch created = batchService.addBatch(dto);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/subject/{subject}")
    public ResponseEntity<List<Batch>> getBatchesBySubject(@PathVariable String subject) {
        List<Batch> batches = batchService.getBatchesBySubject(subject);
        return ResponseEntity.ok(batches);
    }

    @PostMapping("/{batchId}/assign-trainer")
    public ResponseEntity<Batch> assignTrainer(@PathVariable Long batchId) {
        Batch updatedBatch = batchService.assignTrainerToBatch(batchId);
        return ResponseEntity.ok(updatedBatch);
    }
}

