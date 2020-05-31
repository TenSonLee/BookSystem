package com.jl.graduatedesign.service;

import com.jl.graduatedesign.entity.Book;
import com.jl.graduatedesign.vo.BookInfo;
import com.jl.graduatedesign.vo.PagedBookSearchCondition;

import java.util.List;

public interface BookService {
    BookInfo getBookInfoById(Long bookId,Long userId);

    List<Book> getPagedBookList(PagedBookSearchCondition condition);

    int countBookByCondition(PagedBookSearchCondition condition);

    List<Book> getPagedBookListFromFavorites(Long favoritesId,Integer pageIndex,Integer pageSize);

    int countFavoritesBooks(Long favoritesId);
}
