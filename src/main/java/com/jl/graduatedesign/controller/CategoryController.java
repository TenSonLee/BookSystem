package com.jl.graduatedesign.controller;

import com.jl.graduatedesign.entity.Category;
import com.jl.graduatedesign.service.CategoryService;
import com.jl.graduatedesign.vo.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {
    private CategoryService categoryService;

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "/getBookCategory")
    public CommonResponse getBookCategory(){
        CommonResponse<List<Category>> commonResponse = new CommonResponse<>();
        List<Category> categoryList = categoryService.getAllCategory();
        if(null == categoryList){
            categoryList = new ArrayList<>();
        }
        commonResponse.setCode("0");
        commonResponse.setMsg("操作成功");
        commonResponse.setData(categoryList);
        return commonResponse;
    }
}
