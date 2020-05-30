package com.jl.graduatedesign.service;

import com.jl.graduatedesign.entity.Recommend;

public interface RecommendService {
    boolean recommendBook(Recommend recommend) throws Exception;

    boolean cancelRecommend(Recommend recommend) throws Exception;
}
