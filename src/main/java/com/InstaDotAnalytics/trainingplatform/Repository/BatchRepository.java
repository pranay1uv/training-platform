package com.InstaDotAnalytics.trainingplatform.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.InstaDotAnalytics.trainingplatform.Model.Batch;

@Repository
public interface BatchRepository extends JpaRepository<Batch, Long> {
    List<Batch> findBySubject(String subject);
}
