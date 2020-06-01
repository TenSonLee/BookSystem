package com.jl.graduatedesign.dao;

import com.jl.graduatedesign.entity.Favorites;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FavoritesDao {
    List<Favorites> getFavoritesListByUserId(Long userId);

    int removeBookFromFavorites(Long bookId,Long favoritesId);

    int clearFavorites(Long favoritesId);

    int deleteFavorites(Long favoritesId);

    int insertFavorites(Favorites favorites);

    int insertBookToFavorites(Long bookId,Long favoritesId);

    int updateBookFavorites(Long id,Long favoritesId,Long bookId,Date time);

    Long getRecordId(Long bookId,Long favoritesId);
}
