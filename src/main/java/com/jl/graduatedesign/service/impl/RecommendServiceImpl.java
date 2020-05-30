package com.jl.graduatedesign.service.impl;

import com.jl.graduatedesign.dao.BookDao;
import com.jl.graduatedesign.dao.RecommendDao;
import com.jl.graduatedesign.entity.Book;
import com.jl.graduatedesign.entity.Recommend;
import com.jl.graduatedesign.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Component
public class RecommendServiceImpl implements RecommendService {
    private RecommendDao recommendDao;

    private BookDao bookDao;

    @Autowired
    public void setRecommendDao(RecommendDao recommendDao) {
        this.recommendDao = recommendDao;
    }

    @Autowired
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean recommendBook(Recommend recommend) throws Exception{
        if (null == recommendDao.getByUserAndBookId(recommend.getUserId(), recommend.getBookId())) {
            recommend.setTime(new Date());
            recommendDao.addRecommend(recommend);
            Book book = bookDao.getBookById(recommend.getBookId());
            book.setRecommendNum(book.getRecommendNum() + 1);
            int updateCount = bookDao.updateBook(book);
            if(updateCount>0){
                return true;
            }
            throw new Exception("推荐操作未正常完成");
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean cancelRecommend(Recommend recommend) throws Exception{
        int delCount = recommendDao.deleteRecommend(recommend.getUserId(),recommend.getBookId());
        if(delCount > 0){
            Book book = bookDao.getBookById(recommend.getBookId());
            book.setRecommendNum(book.getRecommendNum() - 1);
            int updateCount = bookDao.updateBook(book);
            if(updateCount>0){
                return true;
            }
            throw new Exception("取消推荐操作未正常完成");
        }
        return false;
    }
}
