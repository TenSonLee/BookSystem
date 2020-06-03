package com.jl.graduatedesign.controller;

import com.jl.graduatedesign.algorithm.PersonalRecommend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class AlgorithmController {
    private PersonalRecommend personalRecommend;

    @Autowired
    public void setPersonalRecommend(PersonalRecommend personalRecommend) {
        this.personalRecommend = personalRecommend;
    }

    @RequestMapping("/buildData")
    public void buildData() throws IOException {
        personalRecommend.buildDataFileFromDatabase();
    }

    @RequestMapping("/initPersonalRecommendData")
    public void initPersonalRecommendData(Long userId) throws Exception {
        personalRecommend.userCf(userId, 20);
    }
}
