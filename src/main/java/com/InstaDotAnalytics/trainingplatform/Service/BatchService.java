package com.InstaDotAnalytics.trainingplatform.Service;


import java.util.List;

import com.InstaDotAnalytics.trainingplatform.Dto.BatchRequestDTO;
import com.InstaDotAnalytics.trainingplatform.Model.Batch;

public interface BatchService {
    Batch addBatch(BatchRequestDTO dto);
    List<Batch> getBatchesBySubject(String subject);
    Batch assignTrainerToBatch(Long batchId);
}

