package com.jl.graduatedesign.entity;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "t_evaluate")
public class Evaluation {
    @Column(name = "evaluation_id")
    private Long evaluationId;

    @Column(name = "user_id")
    private Long userId;

    private String userName;

    @Column(name = "book_id")
    private Long bookId;

    private Integer score;

    private String content;

    private Date time;

    private Integer index;

    @Override
    public String toString() {
        return "Evaluation{" +
                "evaluationId=" + evaluationId +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", bookId=" + bookId +
                ", score=" + score +
                ", content='" + content + '\'' +
                ", time=" + time +
                ", index=" + index +
                '}';
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getEvaluationId() {
        return evaluationId;
    }

    public void setEvaluationId(Long evaluationId) {
        this.evaluationId = evaluationId;
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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
