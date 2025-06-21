package com.InstaDotAnalytics.trainingplatform.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.InstaDotAnalytics.trainingplatform.Dto.TrainerRequestDTO;
import com.InstaDotAnalytics.trainingplatform.Model.Trainer;
import com.InstaDotAnalytics.trainingplatform.Repository.TrainerRepository;

@Service
public class TrainerServiceImpl implements TrainerService {

    @Autowired
    private TrainerRepository trainerRepository;

    @Override
    public Trainer addTrainer(TrainerRequestDTO dto) {
        Trainer trainer = new Trainer();
        trainer.setName(dto.getName());
        trainer.setSubjectExpertise(dto.getSubjectExpertise());
        trainer.setRating(dto.getRating());
        trainer.setAvailabilityPeriods(dto.getAvailabilityPeriods());

        return trainerRepository.save(trainer);
    }

	@Override
	public List<Trainer> getAllAvailableTrainers() {
		// TODO Auto-generated method stub
		return trainerRepository.findAll();
	}
}

