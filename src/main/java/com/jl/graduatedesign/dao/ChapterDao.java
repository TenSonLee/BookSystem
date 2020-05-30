package com.jl.graduatedesign.dao;

import com.jl.graduatedesign.entity.Chapter;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChapterDao {
    List<Chapter> queryChapterListByBookId(Long bookId);
}
