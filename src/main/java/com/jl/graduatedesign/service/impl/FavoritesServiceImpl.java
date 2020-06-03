package com.jl.graduatedesign.service.impl;

import com.jl.graduatedesign.dao.BookDao;
import com.jl.graduatedesign.dao.FavoritesDao;
import com.jl.graduatedesign.entity.Book;
import com.jl.graduatedesign.entity.Favorites;
import com.jl.graduatedesign.service.FavoritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Component
public class FavoritesServiceImpl implements FavoritesService {
    private FavoritesDao favoritesDao;

    private BookDao bookDao;

    @Autowired
    public void setFavoritesDao(FavoritesDao favoritesDao) {
        this.favoritesDao = favoritesDao;
    }

    @Autowired
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public List<Favorites> getFavoritesListByUserId(Long userId) {
        return favoritesDao.getFavoritesListByUserId(userId);
    }

    @Override
    public boolean removeBookFromFavorites(Long bookId, Long favoritesId) {
        if(favoritesDao.removeBookFromFavorites(bookId,favoritesId)>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean clearFavorites(Long favoritesId) {
        if(favoritesDao.clearFavorites(favoritesId)>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean clearAndDeleteFavorites(Long favoritesId) {
        favoritesDao.clearFavorites(favoritesId);
        favoritesDao.deleteFavorites(favoritesId);
        return true;
    }

    @Override
    public boolean addNewFavorites(Long userId, String name) {
        Favorites favorites = new Favorites();
        favorites.setUserId(userId);
        favorites.setName(name);
        if(favoritesDao.insertFavorites(favorites)>0){
            return true;
        };
        return false;
    }

    @Override
    public boolean moveBookToAnotherFavorites(Long bookId, Long fromFavoritesId, Long toFavoritesId) {
        Long recordId = favoritesDao.getRecordId(bookId, fromFavoritesId);
        if(favoritesDao.updateBookFavorites(recordId,toFavoritesId,bookId,new Date())>0){
            return true;
        };
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addBookToFavorites(Long bookId, Long favoritesId) throws Exception {
        if(null == favoritesDao.getRecordId(bookId, favoritesId)){
            if(favoritesDao.insertBookToFavorites(bookId, favoritesId)>0){
                    Book book = bookDao.getBookById(bookId);
                    book.setFavoritesNum(book.getFavoritesNum() + 1);
                    int updateCount = bookDao.updateBook(book);
                    if(updateCount > 0){
                        return true;
                    }
                throw new Exception("添加收藏操作未完成");
            };
        };
        return false;
    }
}
