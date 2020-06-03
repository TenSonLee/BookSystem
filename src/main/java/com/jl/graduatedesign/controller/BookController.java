package com.jl.graduatedesign.controller;

import com.jl.graduatedesign.entity.Book;
import com.jl.graduatedesign.entity.Evaluation;
import com.jl.graduatedesign.service.BookService;
import com.jl.graduatedesign.vo.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.WritableResource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    @RequestMapping(value = "/getPagedHotBookList")
    public PagedResponse getPagedHotBookList(Long userId,Integer pageIndex,Integer pageSize){
        PagedResponse<Book> pagedResponse = new PagedResponse<>();
        List<Book> bookList = bookService.getPagedHotBookList(userId, pageIndex, pageSize);
        int count = bookService.countBook();
        count = count>20?20:count;
        pagedResponse.setRel(true);
        pagedResponse.setMsg("操作成功");
        pagedResponse.setList(bookList);
        pagedResponse.setCount(count);
        return pagedResponse;
    }

    @RequestMapping(value = "/getPagedPersonalBookList")
    public PagedResponse getPagedPersonalBookList(Long userId,Integer pageIndex,Integer pageSize){
        PagedResponse<Book> pagedResponse = new PagedResponse<>();
        List<Book> bookList = bookService.getPagedPersonalBookList(userId, pageIndex, pageSize);
        int count = bookService.countPersonalBoolList(userId);
        count = count>20?20:count;
        pagedResponse.setRel(true);
        pagedResponse.setMsg("操作成功");
        pagedResponse.setList(bookList);
        pagedResponse.setCount(count);
        return pagedResponse;
    }

    @RequestMapping(value = "/deleteBookById")
    public CommonResponse deleteBookById(Long bookId){
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setCode("-1");
        commonResponse.setMsg("操作失败");
        if(bookService.deleteBookById(bookId)){
            commonResponse.setCode("0");
            commonResponse.setMsg("操作成功");
        };
        return commonResponse;
    }

    @RequestMapping(value = "/getPagedBookInfoList")
    public PagedResponse getPagedBookInfoList(PagedBookSearchCondition condition){
        System.out.println(condition);
        PagedResponse<Book> pagedResponse = new PagedResponse<>();
        List<Book> bookList = bookService.getPagedBookListInAdmin(condition);
        int count = bookService.countBookInAdmin(condition);
        pagedResponse.setRel(true);
        pagedResponse.setMsg("操作成功");
        pagedResponse.setList(bookList);
        pagedResponse.setCount(count);
        return pagedResponse;
    }

    @RequestMapping(value = "/uploadCover")
    public CommonResponse uploadCover(MultipartFile file) throws IOException {
        Date date = new Date();
        String path="target\\classes\\static\\img\\"+date.getTime()+file.getOriginalFilename();
        path = path.replace("\\", "/");
        WritableResource pathResource = new PathResource(path);
        OutputStream outputStream = pathResource.getOutputStream();
        outputStream.write(file.getBytes());
        outputStream.close();
        String src = "./img/"+date.getTime()+file.getOriginalFilename();
        CommonResponse<String> commonResponse = new CommonResponse<>();
        commonResponse.setCode("0");
        commonResponse.setMsg("上传成功");
        commonResponse.setData(src);
        return commonResponse;
    }

    @RequestMapping(value = "/updateBookInfo")
    public CommonResponse updateBookInfo(BookVo bookvo) throws ParseException {
        System.out.println(bookvo);
        Book book = new Book();
        BeanUtils.copyProperties(bookvo,book);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        book.setPubdate(sdf.parse(bookvo.getPubdate()));
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setCode("-1");
        commonResponse.setMsg("操作失败");
        if(bookService.updateBookInfo(book)){
            commonResponse.setCode("0");
            commonResponse.setMsg("操作成功");
        };
        return commonResponse;
    }

    @RequestMapping(value = "/addNewBook")
    public CommonResponse addNewBook(BookVo bookvo) throws ParseException {
        Book book = new Book();
        BeanUtils.copyProperties(bookvo,book);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        book.setPubdate(sdf.parse(bookvo.getPubdate()));
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setCode("-1");
        commonResponse.setMsg("操作失败");
        if(bookService.addNewBook(book)){
            commonResponse.setCode("0");
            commonResponse.setMsg("操作成功");
        };
        return commonResponse;
    }
}
