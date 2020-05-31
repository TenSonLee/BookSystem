package com.jl.graduatedesign.service.impl;

import com.jl.graduatedesign.dao.BookDao;
import com.jl.graduatedesign.dao.EvaluationDao;
import com.jl.graduatedesign.dao.RecommendDao;
import com.jl.graduatedesign.entity.Book;
import com.jl.graduatedesign.service.BookService;
import com.jl.graduatedesign.vo.BookInfo;
import com.jl.graduatedesign.vo.PagedBookSearchCondition;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookServiceImpl implements BookService {
    private BookDao bookDao;

    private RecommendDao recommendDao;

    private EvaluationDao evaluationDao;

    @Autowired
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Autowired
    public void setRecommendDao(RecommendDao recommendDao) {
        this.recommendDao = recommendDao;
    }

    @Autowired
    public void setEvaluationDao(EvaluationDao evaluationDao){
        this.evaluationDao = evaluationDao;
    }

    @Override
    public BookInfo getBookInfoById(Long bookId,Long userId) {
        Book book = bookDao.getBookById(bookId);
        BookInfo bookInfo = new BookInfo();
        BeanUtils.copyProperties(book,bookInfo);
        if(null == recommendDao.getByUserAndBookId(userId,bookId)){
            bookInfo.setRecommended(false);
        }else {
            bookInfo.setRecommended(true);
        };
        bookInfo.setScore(evaluationDao.getBookTotalScore(bookId));
        return bookInfo;
    }

    @Override
    public List<Book> getPagedBookList(PagedBookSearchCondition condition) {
        return bookDao.getPagedBookListByCondition(condition);
    }

    @Override
    public int countBookByCondition(PagedBookSearchCondition condition) {
        return bookDao.countBookByCondition(condition);
    }

    @Override
    public List<Book> getPagedBookListFromFavorites(Long favoritesId, Integer pageIndex, Integer pageSize) {
        return bookDao.getPagedBookListFromFavorites(favoritesId,pageIndex,pageSize);
    }

    @Override
    public int countFavoritesBooks(Long favoritesId) {
        return bookDao.countFavoritesBooks(favoritesId);
    }
}
