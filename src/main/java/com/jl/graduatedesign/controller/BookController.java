package com.jl.graduatedesign.controller;

import com.jl.graduatedesign.entity.Book;
import com.jl.graduatedesign.entity.Evaluation;
import com.jl.graduatedesign.service.BookService;
import com.jl.graduatedesign.vo.BookInfo;
import com.jl.graduatedesign.vo.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    private BookService bookService;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/getBookInfo")
    public CommonResponse getBookInfo(@RequestBody Evaluation evaluation){
        CommonResponse<BookInfo> commonResponse = new CommonResponse<>();
        BookInfo bookInfo = bookService.getBookInfoById(evaluation.getBookId(),evaluation.getUserId());
        if(bookInfo == null){
            bookInfo = new BookInfo();
        }
        commonResponse.setCode("0");
        commonResponse.setMsg("操作成功");
        commonResponse.setData(bookInfo);
        return commonResponse;
    }
}
