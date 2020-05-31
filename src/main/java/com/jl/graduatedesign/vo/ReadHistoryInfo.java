package com.jl.graduatedesign.vo;

import java.util.Date;

public class ReadHistoryInfo {
    private Long historyId;

    private Long userId;

    private Long bookId;

    private Long chapterId;

    private String chapterTitle;

    private String bookTitle;

    private String author;

    private String desc;

    private String cover;

    private String time;

    @Override
    public String toString() {
        return "ReadHistoryInfo{" +
                "historyId=" + historyId +
                ", userId=" + userId +
                ", bookId=" + bookId +
                ", chapterId=" + chapterId +
                ", chapterTitle='" + chapterTitle + '\'' +
                ", bookTitle='" + bookTitle + '\'' +
                ", author='" + author + '\'' +
                ", desc='" + desc + '\'' +
                ", cover='" + cover + '\'' +
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

    public String getChapterTitle() {
        return chapterTitle;
    }

    public void setChapterTitle(String chapterTitle) {
        this.chapterTitle = chapterTitle;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
