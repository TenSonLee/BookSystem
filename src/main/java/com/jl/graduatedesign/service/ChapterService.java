package com.jl.graduatedesign.service;

import com.jl.graduatedesign.entity.Chapter;
import com.jl.graduatedesign.vo.ReadChapterData;

import java.util.List;

public interface ChapterService {
    List<Chapter> getChapterList(Long bookId);

    ReadChapterData readChapter(Long userId,Long chapterId);

    Chapter getChapterByBookIdAndSeries(Long bookId,Integer series);
}
