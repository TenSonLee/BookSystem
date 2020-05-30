package com.jl.graduatedesign.service;

import com.jl.graduatedesign.entity.Evaluation;

public interface EvaluationService {
    Evaluation getEvaluationByUserAndBookId(Long userId,Long bookId);

    boolean addOrUpdateEvaluation(Evaluation evaluation) throws Exception;

    boolean deleteEvaluation(Evaluation evaluation) throws Exception;
}
