package com.jl.graduatedesign.service.impl;

import com.jl.graduatedesign.dao.FavoritesDao;
import com.jl.graduatedesign.entity.Favorites;
import com.jl.graduatedesign.service.FavoritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FavoritesServiceImpl implements FavoritesService {
    private FavoritesDao favoritesDao;

    @Autowired
    public void setFavoritesDao(FavoritesDao favoritesDao) {
        this.favoritesDao = favoritesDao;
    }

    @Override
    public List<Favorites> getFavoritesListByUserId(Long userId) {
        return favoritesDao.getFavoritesListByUserId(userId);
    }
}
