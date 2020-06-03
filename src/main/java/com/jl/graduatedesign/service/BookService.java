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

    List<Book> getPagedHotBookList(Long userId,Integer pageIndex,Integer pageSize);

    int countBook();

    List<Book> getPagedPersonalBookList(Long userId,Integer pageIndex,Integer pageSize);

    int countPersonalBoolList(Long userId);

    boolean deleteBookById(Long bookId);

    List<Book> getPagedBookListInAdmin(PagedBookSearchCondition condition);

    int countBookInAdmin(PagedBookSearchCondition condition);

    boolean updateBookInfo(Book book);

    boolean addNewBook(Book book);
}
