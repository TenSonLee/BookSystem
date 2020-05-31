package com.jl.graduatedesign.entity;

import java.util.Date;

public class ReadHistory {
    private Long historyId;

    private Long userId;

    private Long bookId;

    private Long chapterId;

    private Date time;

    @Override
    public String toString() {
        return "ReadHistory{" +
                "historyId=" + historyId +
                ", userId=" + userId +
                ", bookId=" + bookId +
                ", chapterId=" + chapterId +
                ", time=" + time +
                '}';
    }

    public Long getHistoryId() {
        return historyId;
    }

    public void setHistoryId(Long historyId) {
        this.historyId = historyId;
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

    public Long getChapterId() {
        return chapterId;
    }

    public void setChapterId(Long chapterId) {
        this.chapterId = chapterId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
