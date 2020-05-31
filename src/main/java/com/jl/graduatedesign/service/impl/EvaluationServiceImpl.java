package com.jl.graduatedesign.service.impl;

import com.jl.graduatedesign.dao.BookDao;
import com.jl.graduatedesign.dao.EvaluationDao;
import com.jl.graduatedesign.dao.UserDao;
import com.jl.graduatedesign.entity.Book;
import com.jl.graduatedesign.entity.Evaluation;
import com.jl.graduatedesign.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Component
public class EvaluationServiceImpl implements EvaluationService {
    private EvaluationDao evaluationDao;

    private BookDao bookDao;

    private UserDao userDao;

    @Autowired
    public void setEvaluationDao(EvaluationDao evaluationDao) {
        this.evaluationDao = evaluationDao;
    }

    @Autowired
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Evaluation getEvaluationByUserAndBookId(Long userId, Long bookId) {
        return evaluationDao.getEvaluationByUserAndBookId(userId,bookId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addOrUpdateEvaluation(Evaluation evaluation) throws Exception{
        Evaluation resultEvaluation = evaluationDao.getEvaluationByUserAndBookId(evaluation.getUserId(),evaluation.getBookId());
        evaluation.setTime(new Date());
        //根据是否已存在对应的评价来判断进行插入或是更新操作
        if(resultEvaluation == null){
            int insertCount = evaluationDao.insertEvaluation(evaluation);
            if(insertCount > 0) {
                Book book = bookDao.getBookById(evaluation.getBookId());
                book.setEvaluationNum(book.getEvaluationNum() + 1);
                int updateCount = bookDao.updateBook(book);
                if(updateCount > 0){
                    return true;
                }
            }
            throw new Exception("评价操作未正常完成");
        }else {
            evaluation.setEvaluationId(resultEvaluation.getEvaluationId());
            int updateCount2 = evaluationDao.updateEvaluation(evaluation);
            if(updateCount2 > 0){
                return true;
            }
            throw new Exception("评价操作未正常完成");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteEvaluation(Evaluation evaluation) throws Exception{
        int delCount = evaluationDao.deleteEvaluation(evaluation.getUserId(),evaluation.getBookId());
        if(delCount > 0){
            Book book = bookDao.getBookById(evaluation.getBookId());
            book.setEvaluationNum(book.getEvaluationNum() - 1);
            int updateCount = bookDao.updateBook(book);
            if(updateCount>0){
                return true;
            }
            throw new Exception("删除评价操作未正常完成");
        }
        return false;
    }

    @Override
    public List<Evaluation> getPagedEvaluationList(Long bookId, Integer pageIndex, Integer pageSize) {
        List<Evaluation> evaluationList = evaluationDao.queryPagedEvaluationList(bookId, pageIndex, pageSize);
        int i = 1;
        for (Evaluation e:
             evaluationList) {
            e.setUserName(userDao.getUserNameById(e.getUserId()));
            e.setIndex((pageIndex-1)*pageSize+i);
            i++;
        }
        return evaluationList;
    }

    @Override
    public int countEvaluationByBookId(Long bookId) {
        return evaluationDao.countEvaluationNum(bookId);
    }
}
