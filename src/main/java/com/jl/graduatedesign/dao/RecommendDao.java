package com.jl.graduatedesign.dao;

import com.jl.graduatedesign.entity.Recommend;
import org.springframework.stereotype.Repository;

@Repository
public interface RecommendDao {
    Recommend getByUserAndBookId(Long userId,Long bookId);

    int addRecommend(Recommend recommend);

    int deleteRecommend(Long userId,Long bookId);
}
