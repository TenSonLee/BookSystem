package com.jl.graduatedesign.entity;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "t_chapter")
public class Chapter {
    @Column(name = "chapter_id")
    private Long chapterId;

    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "content_id")
    private Long contentId;

    private String title;

    private Integer words;

    private Integer series;

    @Override
    public String toString() {
        return "Chapter{" +
                "chapterId=" + chapterId +
                ", bookId=" + bookId +
                ", contentId=" + contentId +
                ", title='" + title + '\'' +
                ", words=" + words +
                ", series=" + series +
                '}';
    }

    public Long getChapterId() {
        return chapterId;
    }

    public void setChapterId(Long chapterId) {
        this.chapterId = chapterId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getContentId() {
        return contentId;
    }

    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getWords() {
        return words;
    }

    public void setWords(Integer words) {
        this.words = words;
    }

    public Integer getSeries() {
        return series;
    }

    public void setSeries(Integer series) {
        this.series = series;
    }
}
