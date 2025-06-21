package com.InstaDotAnalytics.trainingplatform.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.InstaDotAnalytics.trainingplatform.Model.Trainer;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Long> {
	
}
