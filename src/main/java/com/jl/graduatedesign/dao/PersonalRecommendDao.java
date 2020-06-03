package com.jl.graduatedesign.dao;

import com.jl.graduatedesign.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonalRecommendDao {
    int insertPersonalRecommendInfo(Long userId,Long bookId,String value);

    List<Book> getPagedPersonalBookList(Long userId,Integer pageIndex,Integer pageSize);

    int countByUserId(Long userId);

    int clearByUserId(Long userId);
}
