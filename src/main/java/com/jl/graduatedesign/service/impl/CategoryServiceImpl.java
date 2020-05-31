package com.jl.graduatedesign.service.impl;

import com.jl.graduatedesign.dao.CategoryDao;
import com.jl.graduatedesign.entity.Category;
import com.jl.graduatedesign.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryServiceImpl implements CategoryService {
    private CategoryDao categoryDao;

    @Autowired
    public void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryDao.getAllCategory();
    }
}
