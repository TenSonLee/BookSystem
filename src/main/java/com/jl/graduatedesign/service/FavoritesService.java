package com.jl.graduatedesign.service;

import com.jl.graduatedesign.entity.Favorites;

import java.util.List;

public interface FavoritesService {
    List<Favorites> getFavoritesListByUserId(Long userId);

    boolean removeBookFromFavorites(Long bookId,Long favoritesId);

    boolean clearFavorites(Long favoritesId);

    boolean clearAndDeleteFavorites(Long favoritesId);

    boolean addNewFavorites(Long userId,String name);

    boolean moveBookToAnotherFavorites(Long bookId,Long fromFavoritesId,Long toFavoritesId);

    boolean addBookToFavorites(Long bookId,Long favoritesId);
}
