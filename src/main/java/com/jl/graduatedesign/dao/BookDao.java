package com.jl.graduatedesign.dao;

import com.jl.graduatedesign.entity.Book;
import com.jl.graduatedesign.vo.PagedBookSearchCondition;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDao {
    Book getBookById(Long bookId);

    int updateBook(Book book);

    List<Book> getPagedBookListByCondition(PagedBookSearchCondition condition);

    int countBookByCondition(PagedBookSearchCondition condition);

    List<Book> getPagedBookListFromFavorites(Long favoritesId,Integer pageIndex,Integer pageSize);

    List<Book> getPagedBookListInAdmin(PagedBookSearchCondition condition);

    int countBookInAdmin(PagedBookSearchCondition condition);

    int countFavoritesBooks(Long favoritesId);

    List<Book> getPagedHotBookList(Integer pageIndex,Integer pageSize);

    int countBook();

    int deleteBookById(Long bookId);

    int insertBook(Book book);
}
