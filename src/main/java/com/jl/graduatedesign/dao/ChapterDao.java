package com.jl.graduatedesign.dao;

import com.jl.graduatedesign.entity.Chapter;
import com.jl.graduatedesign.vo.PagedChapterSearchCondition;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChapterDao {
    List<Chapter> queryChapterListByBookId(Long bookId);

    Chapter getChapterInfoById(Long chapterId);

    String getContent(Long chapterId);

    Chapter getChapterByBookIdAndSeries(Long bookId,Integer series);

    List<Chapter> getPagedChapterListByCondition(PagedChapterSearchCondition condition);

    int countChapterByCondition(PagedChapterSearchCondition condition);

    int insertChapter(Chapter chapter);

    int insertContent(Chapter chapter);

    int updateChapter(Chapter chapter);

    int updateContent(Chapter chapter);

    int deleteChapter(Long chapterId);

    int deleteContent(Long chapterId);
}
