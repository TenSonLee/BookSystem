package com.jl.graduatedesign.dao;

import com.jl.graduatedesign.entity.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDao {
    Book getBookById(Long bookId);

    int updateBook(Book book);
}
