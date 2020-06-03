package com.jl.graduatedesign.service;

import com.jl.graduatedesign.entity.Evaluation;
import com.jl.graduatedesign.vo.PagedEvaluationSearchCondition;

import java.util.List;

public interface EvaluationService {
    Evaluation getEvaluationByUserAndBookId(Long userId,Long bookId);

    boolean addOrUpdateEvaluation(Evaluation evaluation) throws Exception;

    boolean deleteEvaluation(Evaluation evaluation) throws Exception;

    List<Evaluation> getPagedEvaluationList(Long bookId,Integer pageIndex,Integer pageSize);

    int countEvaluationByBookId(Long bookId);

    List<Evaluation> getPagedEvaluationListByCondition(PagedEvaluationSearchCondition condition);

    int countEvaluationByCondition(PagedEvaluationSearchCondition condition);
}
