package com.jl.graduatedesign.controller;

import com.jl.graduatedesign.entity.Chapter;
import com.jl.graduatedesign.entity.ReadHistory;
import com.jl.graduatedesign.service.ChapterService;
import com.jl.graduatedesign.vo.CommonResponse;
import com.jl.graduatedesign.vo.ReadChapterData;
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

    @RequestMapping(value = "/readChapterContent")
    public CommonResponse readChapterContent(@RequestBody ReadHistory readHistory){
        CommonResponse<ReadChapterData> commonResponse = new CommonResponse<>();
        ReadChapterData readChapterData = chapterService.readChapter(readHistory.getUserId(), readHistory.getChapterId());
        commonResponse.setCode("0");
        commonResponse.setMsg("操作成功");
        commonResponse.setData(readChapterData);
        return commonResponse;
    }

    @RequestMapping(value = "/startRead")
    public CommonResponse startRead(Long bookId){
        CommonResponse<Long> commonResponse = new CommonResponse<>();
        //获取图书的第一章
        Chapter chapter = chapterService.getChapterByBookIdAndSeries(bookId, 1);
        commonResponse.setCode("0");
        commonResponse.setMsg("操作成功");
        commonResponse.setData(chapter.getChapterId());
        return commonResponse;
    }
}
