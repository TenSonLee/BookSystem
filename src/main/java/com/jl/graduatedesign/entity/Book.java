package com.jl.graduatedesign.entity;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "t_book")
public class Book {
    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "book_category_id")
    private Long bookCategoryId;

    private String title;

    private String desc;

    private String cover;

    private String author;

    private String publisher;

    private Date pubdate;

    @Column(name = "favorites_num")
    private Integer favoritesNum;

    @Column(name = "evaluation_num")
    private Integer evaluationNum;

    @Column(name = "recommend_num")
    private Integer recommendNum;

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookCategoryId=" + bookCategoryId +
                ", title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", cover='" + cover + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", pubdate=" + pubdate +
                ", favoritesNum=" + favoritesNum +
                ", evaluationNum=" + evaluationNum +
                ", recommendNum=" + recommendNum +
                '}';
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getBookCategoryId() {
        return bookCategoryId;
    }

    public void setBookCategoryId(Long bookCategoryId) {
        this.bookCategoryId = bookCategoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getPubdate() {
        return pubdate;
    }

    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }

    public Integer getFavoritesNum() {
        return favoritesNum;
    }

    public void setFavoritesNum(Integer favoritesNum) {
        this.favoritesNum = favoritesNum;
    }

    public Integer getEvaluationNum() {
        return evaluationNum;
    }

    public void setEvaluationNum(Integer evaluationNum) {
        this.evaluationNum = evaluationNum;
    }

    public Integer getRecommendNum() {
        return recommendNum;
    }

    public void setRecommendNum(Integer recommendNum) {
        this.recommendNum = recommendNum;
    }
}
