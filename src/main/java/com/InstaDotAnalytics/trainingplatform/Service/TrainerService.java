package com.InstaDotAnalytics.trainingplatform.Service;


import java.util.List;

import com.InstaDotAnalytics.trainingplatform.Dto.TrainerRequestDTO;
import com.InstaDotAnalytics.trainingplatform.Model.Trainer;

public interface TrainerService {
    Trainer addTrainer(TrainerRequestDTO dto);
    List<Trainer> getAllAvailableTrainers();
}


