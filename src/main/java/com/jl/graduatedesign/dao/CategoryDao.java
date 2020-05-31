package com.jl.graduatedesign.dao;

import com.jl.graduatedesign.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryDao {
    List<Category> getAllCategory();
}
