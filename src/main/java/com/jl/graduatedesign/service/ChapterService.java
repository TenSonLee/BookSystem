package com.jl.graduatedesign.service;

import com.jl.graduatedesign.entity.Chapter;

import java.util.List;

public interface ChapterService {
    List<Chapter> getChapterList(Long bookId);
}
