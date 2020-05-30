package com.jl.graduatedesign.controller;

import com.jl.graduatedesign.entity.Evaluation;
import com.jl.graduatedesign.service.EvaluationService;
import com.jl.graduatedesign.vo.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EvaluationController {
    private EvaluationService evaluationService;

    @Autowired
    public void setEvaluationService(EvaluationService evaluationService) {
        this.evaluationService = evaluationService;
    }

    @RequestMapping(value = "/getMyEvaluation")
    public CommonResponse getMyEvaluation(@RequestBody  Evaluation evaluation){
        CommonResponse<Evaluation> commonResponse = new CommonResponse<>();
        Evaluation returnEvaluation = evaluationService.getEvaluationByUserAndBookId(evaluation.getUserId(),evaluation.getBookId());
        if(returnEvaluation == null){
            returnEvaluation = new Evaluation();
        }
        commonResponse.setCode("0");
        commonResponse.setMsg("操作成功");
        commonResponse.setData(returnEvaluation);
        return commonResponse;
    }

    @RequestMapping(value = "/addEvaluation")
    public CommonResponse addEvaluation(@RequestBody Evaluation evaluation) throws Exception {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setCode("-1");
        commonResponse.setMsg("操作失败");
        if(evaluationService.addOrUpdateEvaluation(evaluation)){
            commonResponse.setCode("0");
            commonResponse.setMsg("操作成功");
        };
        return commonResponse;
    }

    @RequestMapping(value = "/deleteEvaluation")
    public CommonResponse deleteEvaluation(@RequestBody Evaluation evaluation) throws Exception{
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setCode("-1");
        commonResponse.setMsg("操作失败");
        if(evaluationService.deleteEvaluation(evaluation)){
            commonResponse.setCode("0");
            commonResponse.setMsg("操作成功");
        };
        return commonResponse;
    }
}