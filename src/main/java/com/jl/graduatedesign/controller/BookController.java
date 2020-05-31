package com.jl.graduatedesign.controller;

import com.jl.graduatedesign.entity.Book;
import com.jl.graduatedesign.entity.Evaluation;
import com.jl.graduatedesign.service.BookService;
import com.jl.graduatedesign.vo.BookInfo;
import com.jl.graduatedesign.vo.CommonResponse;
import com.jl.graduatedesign.vo.PagedBookSearchCondition;
import com.jl.graduatedesign.vo.PagedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @RequestMapping(value = "/queryBookListByCondition")
    public PagedResponse queryBookListByCondition(PagedBookSearchCondition condition){
        PagedResponse<Book> pagedResponse = new PagedResponse<>();
        List<Book> bookList = bookService.getPagedBookList(condition);
        int count = bookService.countBookByCondition(condition);
        pagedResponse.setRel(true);
        pagedResponse.setMsg("操作成功");
        pagedResponse.setList(bookList);
        pagedResponse.setCount(count);
        return pagedResponse;
    }

    @RequestMapping(value = "/queryBookListFromFavorites")
    public PagedResponse queryBookListFromFavorites(Long favoritesId,Integer pageIndex,Integer pageSize){
        PagedResponse<Book> pagedResponse = new PagedResponse<>();
        List<Book> bookList = bookService.getPagedBookListFromFavorites(favoritesId, pageIndex, pageSize);
        int count = bookService.countFavoritesBooks(favoritesId);
        pagedResponse.setRel(true);
        pagedResponse.setMsg("操作成功");
        pagedResponse.setList(bookList);
        pagedResponse.setCount(count);
        return pagedResponse;
    }
}
