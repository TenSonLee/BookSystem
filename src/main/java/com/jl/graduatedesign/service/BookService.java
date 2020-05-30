package com.jl.graduatedesign.service;

import com.jl.graduatedesign.entity.Book;
import com.jl.graduatedesign.vo.BookInfo;

public interface BookService {
    BookInfo getBookInfoById(Long bookId,Long userId);
}
