package com.jl.graduatedesign.dao;

import com.jl.graduatedesign.entity.Evaluation;
import com.jl.graduatedesign.vo.PagedEvaluationSearchCondition;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluationDao {
    Evaluation getEvaluationByUserAndBookId(Long userId,Long bookId);

    int getBookTotalScore(Long bookId);

    int updateEvaluation(Evaluation evaluation);

    int insertEvaluation(Evaluation evaluation);

    int deleteEvaluation(Long userId,Long bookId);

    List<Evaluation> queryPagedEvaluationList(Long bookId,Integer pageIndex,Integer pageSize);

    int countEvaluationNum(Long bookId);

    List<Evaluation> getPagedEvaluationListByCondition(PagedEvaluationSearchCondition condition);

    int countEvaluationListByCondition(PagedEvaluationSearchCondition condition);
}
