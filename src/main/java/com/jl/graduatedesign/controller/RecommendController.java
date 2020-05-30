package com.jl.graduatedesign.controller;

import com.jl.graduatedesign.entity.Recommend;
import com.jl.graduatedesign.service.RecommendService;
import com.jl.graduatedesign.vo.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecommendController {
    private RecommendService recommendService;

    @Autowired
    public void setRecommendService(RecommendService recommendService) {
        this.recommendService = recommendService;
    }

    @RequestMapping(value = "/recommendBook")
    public CommonResponse recommendBook(@RequestBody Recommend recommend) throws Exception{
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setCode("-1");
        commonResponse.setMsg("操作失败");
        if(recommendService.recommendBook(recommend)){
            commonResponse.setCode("0");
            commonResponse.setMsg("操作成功");
        };
        return commonResponse;
    }

    @RequestMapping(value = "/cancelRecommend")
    public CommonResponse cancelRecommend(@RequestBody Recommend recommend) throws Exception{
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setCode("-1");
        commonResponse.setMsg("操作失败");
        if(recommendService.cancelRecommend(recommend)){
            commonResponse.setCode("0");
            commonResponse.setMsg("操作成功");
        };
        return commonResponse;
    }
}
