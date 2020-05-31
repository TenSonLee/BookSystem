package com.jl.graduatedesign.dao;

import com.jl.graduatedesign.entity.Favorites;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoritesDao {
    List<Favorites> getFavoritesListByUserId(Long userId);
}
