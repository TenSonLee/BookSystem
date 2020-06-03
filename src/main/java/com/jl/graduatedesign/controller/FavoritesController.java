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

    @RequestMapping(value = "/removeBookFromFavorites")
    public CommonResponse removeBookFromFavorites(Long bookId,Long favoritesId){
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setCode("-1");
        commonResponse.setMsg("操作失败");
        if(favoritesService.removeBookFromFavorites(bookId, favoritesId)){
            commonResponse.setCode("0");
            commonResponse.setMsg("操作成功");
        };
        return commonResponse;
    }

    @RequestMapping(value = "/clearFavorites")
    public CommonResponse clearFavorites(Long favoritesId){
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setCode("-1");
        commonResponse.setMsg("操作失败");
        if(favoritesService.clearFavorites(favoritesId)){
            commonResponse.setCode("0");
            commonResponse.setMsg("操作成功");
        };
        return commonResponse;
    }

    @RequestMapping(value = "/deleteFavorites")
    public CommonResponse deleteFavorites(Long userId,Long favoritesId){
        CommonResponse<Long> commonResponse = new CommonResponse<>();
        commonResponse.setCode("-1");
        commonResponse.setMsg("操作失败");
        if(favoritesService.clearAndDeleteFavorites(favoritesId)){
            Favorites favorites = favoritesService.getFavoritesListByUserId(userId).get(1);
            if(favorites!=null) {
                commonResponse.setCode("0");
                commonResponse.setMsg("操作成功");
                commonResponse.setData(favorites.getFavoritesId());
            }
        };
        return commonResponse;
    }

    @RequestMapping(value = "/addFavorites")
    public CommonResponse addFavorites(Long userId,String name){
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setCode("-1");
        commonResponse.setMsg("操作失败");
        if(favoritesService.addNewFavorites(userId, name)){
            commonResponse.setCode("0");
            commonResponse.setMsg("操作成功");
        };
        return commonResponse;
    }

    @RequestMapping("/moveBookToAnotherFavorites")
    public CommonResponse moveBookToAnotherFavorites(Long bookId,Long fromFavoritesId,Long toFavoritesId){
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setCode("-1");
        commonResponse.setMsg("操作失败");
        if(favoritesService.moveBookToAnotherFavorites(bookId, fromFavoritesId, toFavoritesId)){
            commonResponse.setCode("0");
            commonResponse.setMsg("操作成功");
        };
        return commonResponse;
    }

    @RequestMapping(value = "/addBookToFavorites")
    public CommonResponse addBookToFavorites(Long bookId,Long favoritesId) throws Exception {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setCode("-1");
        commonResponse.setMsg("图书已在该收藏夹中");
        if(favoritesService.addBookToFavorites(bookId,favoritesId)){
            commonResponse.setCode("0");
            commonResponse.setMsg("操作成功");
        };
        return commonResponse;

    }
}
