package com.jl.graduatedesign.vo;

public class ReadChapterData {
    private Long bookId;

    private String bookTitle;

    private Long chapterId;

    private String chapterTitle;

    private Long contentId;

    private String content;

    private Long nextChapterId;

    private Long prevChapterId;

    private Boolean firstChapter;

    private Boolean lastChapter;

    @Override
    public String toString() {
        return "ReadChapterData{" +
                "bookId=" + bookId +
                ", bookTitle='" + bookTitle + '\'' +
                ", chapterId=" + chapterId +
                ", chapterTitle='" + chapterTitle + '\'' +
                ", contentId=" + contentId +
                ", content='" + content + '\'' +
                ", nextChapterId=" + nextChapterId +
                ", prevChapterId=" + prevChapterId +
                ", firstChapter=" + firstChapter +
                ", lastChapter=" + lastChapter +
                '}';
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
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

    public Long getContentId() {
        return contentId;
    }

    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getNextChapterId() {
        return nextChapterId;
    }

    public void setNextChapterId(Long nextChapterId) {
        this.nextChapterId = nextChapterId;
    }

    public Long getPrevChapterId() {
        return prevChapterId;
    }

    public void setPrevChapterId(Long prevChapterId) {
        this.prevChapterId = prevChapterId;
    }

    public Boolean getFirstChapter() {
        return firstChapter;
    }

    public void setFirstChapter(Boolean firstChapter) {
        this.firstChapter = firstChapter;
    }

    public Boolean getLastChapter() {
        return lastChapter;
    }

    public void setLastChapter(Boolean lastChapter) {
        this.lastChapter = lastChapter;
    }
}
