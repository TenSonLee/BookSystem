package com.jl.graduatedesign.service.impl;

import com.jl.graduatedesign.dao.BookDao;
import com.jl.graduatedesign.dao.EvaluationDao;
import com.jl.graduatedesign.dao.PersonalRecommendDao;
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

    private PersonalRecommendDao personalRecommendDao;

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

    @Autowired
    public void setPersonalRecommendDao(PersonalRecommendDao personalRecommendDao) {
        this.personalRecommendDao = personalRecommendDao;
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

    @Override
    public List<Book> getPagedHotBookList(Long userId, Integer pageIndex, Integer pageSize) {
        return bookDao.getPagedHotBookList(pageIndex, pageSize);
    }

    @Override
    public int countBook(){
        return bookDao.countBook();
    }

    @Override
    public List<Book> getPagedPersonalBookList(Long userId, Integer pageIndex, Integer pageSize) {
        return personalRecommendDao.getPagedPersonalBookList(userId, pageIndex, pageSize);

    }

    @Override
    public int countPersonalBoolList(Long userId) {
        return personalRecommendDao.countByUserId(userId);
    }

    @Override
    public boolean deleteBookById(Long bookId) {
        return bookDao.deleteBookById(bookId)>0;
    }

    @Override
    public List<Book> getPagedBookListInAdmin(PagedBookSearchCondition condition) {
        return bookDao.getPagedBookListInAdmin(condition);
    }

    @Override
    public int countBookInAdmin(PagedBookSearchCondition condition) {
        return bookDao.countBookInAdmin(condition);
    }

    @Override
    public boolean updateBookInfo(Book book) {
        return bookDao.updateBook(book)>0;
    }

    @Override
    public boolean addNewBook(Book book) {
        return bookDao.insertBook(book)>0;
    }
}
