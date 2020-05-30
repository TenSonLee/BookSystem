package com.jl.graduatedesign.entity;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "t_recommend")
public class Recommend {
    @Column(name = "recommend_id")
    private Long recommendId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "book_id")
    private Long bookId;

    private Date time;

    @Override
    public String toString() {
        return "Recommend{" +
                "recommendId=" + recommendId +
                ", userId=" + userId +
                ", bookId=" + bookId +
                ", time=" + time +
                '}';
    }

    public Long getRecommendId() {
        return recommendId;
    }

    public void setRecommendId(Long recommendId) {
        this.recommendId = recommendId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
