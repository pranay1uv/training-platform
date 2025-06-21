package com.InstaDotAnalytics.trainingplatform.Controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.InstaDotAnalytics.trainingplatform.Dto.TrainerRequestDTO;
import com.InstaDotAnalytics.trainingplatform.Model.Trainer;
import com.InstaDotAnalytics.trainingplatform.Service.TrainerService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/trainers")
@RequiredArgsConstructor
public class TrainerController {

    private final TrainerService trainerService;

    @PostMapping
    public ResponseEntity<Trainer> addTrainer(@Valid @RequestBody TrainerRequestDTO dto) {
        Trainer created = trainerService.addTrainer(dto);
        return ResponseEntity.ok(created);
    }
}

