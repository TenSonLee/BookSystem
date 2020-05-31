package com.jl.graduatedesign.dao;

import com.jl.graduatedesign.entity.Chapter;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChapterDao {
    List<Chapter> queryChapterListByBookId(Long bookId);

    Chapter getChapterInfoById(Long chapterId);

    String getContent(Long chapterId);

    Chapter getChapterByBookIdAndSeries(Long bookId,Integer series);
}
