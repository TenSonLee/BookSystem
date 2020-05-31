package com.jl.graduatedesign.vo;

public class PagedBookSearchCondition {
    private Integer sortOrder;

    private Long categoryId;

    private String keyword;

    private Integer pageIndex;

    private Integer pageSize;

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "PagedBookSearchCondition{" +
                "sortOrder=" + sortOrder +
                ", categoryId=" + categoryId +
                ", keyword='" + keyword + '\'' +
                ", pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                '}';
    }
}
