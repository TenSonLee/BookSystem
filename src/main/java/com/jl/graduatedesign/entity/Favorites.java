package com.jl.graduatedesign.entity;

import javax.persistence.Table;

@Table(name = "t_favorites")
public class Favorites {
    private Long favoritesId;

    private Long userId;

    private String name;

    private Integer bookNum;

    @Override
    public String toString() {
        return "Favorites{" +
                "favoritesId=" + favoritesId +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", bookNum=" + bookNum +
                '}';
    }

    public Long getFavoritesId() {
        return favoritesId;
    }

    public void setFavoritesId(Long favoritesId) {
        this.favoritesId = favoritesId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBookNum() {
        return bookNum;
    }

    public void setBookNum(Integer bookNum) {
        this.bookNum = bookNum;
    }
}
