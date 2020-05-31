package com.jl.graduatedesign.controller;

import com.jl.graduatedesign.service.ReadHistoryService;
import com.jl.graduatedesign.vo.CommonResponse;
import com.jl.graduatedesign.vo.ReadHistoryInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReadHistoryController {
    private ReadHistoryService readHistoryService;

    @Autowired
    public void setReadHistoryService(ReadHistoryService readHistoryService) {
        this.readHistoryService = readHistoryService;
    }

    @RequestMapping(value = "/getHistoryList")
    public CommonResponse getHistoryList(Long userId){
        CommonResponse<List<ReadHistoryInfo>> commonResponse = new CommonResponse<>();
        List<ReadHistoryInfo> historyList = readHistoryService.getHistoryList(userId);
        commonResponse.setCode("0");
        commonResponse.setMsg("操作成功");
        commonResponse.setData(historyList);
        return commonResponse;

    }

    @RequestMapping(value = "/deleteHistoryById")
    public CommonResponse deleteHistoryById(Long historyId){
        CommonResponse commonResponse = new CommonResponse();
        if(readHistoryService.deleteHistoryById(historyId)){
            commonResponse.setCode("0");
            commonResponse.setMsg("操作成功");
        }else {
            commonResponse.setCode("-1");
            commonResponse.setMsg("操作失败");
        }
        return commonResponse;
    }

    @RequestMapping(value = "/deleteUserAllHistory")
    public CommonResponse deleteUserAllHistory(Long userId){
        CommonResponse commonResponse = new CommonResponse();
        if(readHistoryService.deleteUserAllHistory(userId)){
            commonResponse.setCode("0");
            commonResponse.setMsg("操作成功");
        }else {
            commonResponse.setCode("-1");
            commonResponse.setMsg("操作失败");
        }
        return commonResponse;
    }
}
