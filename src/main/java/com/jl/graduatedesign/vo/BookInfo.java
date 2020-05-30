package com.jl.graduatedesign.vo;

import com.jl.graduatedesign.entity.Book;

public class BookInfo extends Book {
    private Integer score;

    private Boolean isRecommended;

    @Override
    public String toString() {
        return "BookInfo{" +
                "score=" + score +
                ", isRecommended=" + isRecommended +
                '}';
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Boolean getRecommended() {
        return isRecommended;
    }

    public void setRecommended(Boolean recommended) {
        isRecommended = recommended;
    }
}
