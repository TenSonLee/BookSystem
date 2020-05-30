package com.jl.graduatedesign.dao;

import com.jl.graduatedesign.entity.Evaluation;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluationDao {
    Evaluation getEvaluationByUserAndBookId(Long userId,Long bookId);

    int getBookTotalScore(Long bookId);

    int updateEvaluation(Evaluation evaluation);

    int insertEvaluation(Evaluation evaluation);

    int deleteEvaluation(Long userId,Long bookId);
}
