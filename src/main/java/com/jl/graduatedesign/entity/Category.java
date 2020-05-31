package com.jl.graduatedesign.entity;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "t_category")
public class Category {
    @Column(name = "book_category_id")
    private Long categoryId;

    private String name;

    private String code;

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
