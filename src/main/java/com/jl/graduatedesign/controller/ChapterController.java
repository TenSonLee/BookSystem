package com.jl.graduatedesign.controller;

import com.jl.graduatedesign.entity.Chapter;
import com.jl.graduatedesign.service.ChapterService;
import com.jl.graduatedesign.vo.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ChapterController {
    private ChapterService chapterService;

    @Autowired
    public void setChapterService(ChapterService chapterService) {
        this.chapterService = chapterService;
    }

    @RequestMapping(value = "/getCatalogList")
    public CommonResponse getCatalogList(@RequestBody Long bookId){
        CommonResponse<List<Chapter>> commonResponse = new CommonResponse<>();
        List<Chapter> chapterList = chapterService.getChapterList(bookId);
        if(chapterList == null){
            chapterList = new ArrayList<>();
        }
        commonResponse.setCode("0");
        commonResponse.setMsg("操作成功");
        commonResponse.setData(chapterList);
        return commonResponse;
    }
}
