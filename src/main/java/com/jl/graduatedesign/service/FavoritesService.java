package com.jl.graduatedesign.service;

import com.jl.graduatedesign.entity.Favorites;

import java.util.List;

public interface FavoritesService {
    List<Favorites> getFavoritesListByUserId(Long userId);
}
