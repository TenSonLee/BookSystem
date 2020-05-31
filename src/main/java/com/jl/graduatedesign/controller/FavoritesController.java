package com.jl.graduatedesign.controller;

import com.jl.graduatedesign.entity.Favorites;
import com.jl.graduatedesign.service.FavoritesService;
import com.jl.graduatedesign.vo.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FavoritesController {
    private FavoritesService favoritesService;

    @Autowired
    public void setFavoritesService(FavoritesService favoritesService) {
        this.favoritesService = favoritesService;
    }

    @RequestMapping(value = "/getUserFavoritesList")
    public CommonResponse getUserFavoritesList(Long userId){
        CommonResponse<List<Favorites>> commonResponse = new CommonResponse<>();
        List<Favorites> favoritesList = favoritesService.getFavoritesListByUserId(userId);
        commonResponse.setMsg("操作成功");
        commonResponse.setCode("0");
        commonResponse.setData(favoritesList);
        return commonResponse;
    }
}
