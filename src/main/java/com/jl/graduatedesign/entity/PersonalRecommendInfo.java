package com.jl.graduatedesign.entity;

import javax.persistence.Table;

@Table(name = "t_personal_recommend")
public class PersonalRecommendInfo {
    private Long id;

    private Long userId;

    private Long bookId;

    private String value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "PersonalRecommendInfo{" +
                "id=" + id +
                ", userId=" + userId +
                ", bookId=" + bookId +
                ", value='" + value + '\'' +
                '}';
    }
}
