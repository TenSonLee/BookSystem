package com.jl.graduatedesign.service.impl;

import com.jl.graduatedesign.dao.ChapterDao;
import com.jl.graduatedesign.entity.Chapter;
import com.jl.graduatedesign.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ChapterServiceImpl implements ChapterService {
    private ChapterDao chapterDao;

    @Autowired
    public void setChapterDao(ChapterDao chapterDao) {
        this.chapterDao = chapterDao;
    }

    @Override
    public List<Chapter> getChapterList(Long bookId) {
        return chapterDao.queryChapterListByBookId(bookId);
    }
}
