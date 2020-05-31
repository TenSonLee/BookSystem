package com.jl.graduatedesign.service.impl;

import com.jl.graduatedesign.dao.BookDao;
import com.jl.graduatedesign.dao.ChapterDao;
import com.jl.graduatedesign.dao.ReadHistoryDao;
import com.jl.graduatedesign.entity.Book;
import com.jl.graduatedesign.entity.Chapter;
import com.jl.graduatedesign.entity.ReadHistory;
import com.jl.graduatedesign.service.ReadHistoryService;
import com.jl.graduatedesign.vo.ReadHistoryInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class ReadHistoryServiceImpl implements ReadHistoryService {
    private ReadHistoryDao readHistoryDao;

    private BookDao bookDao;

    private ChapterDao chapterDao;

    @Autowired
    public void setReadHistoryDao(ReadHistoryDao readHistoryDao) {
        this.readHistoryDao = readHistoryDao;
    }

    @Autowired
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Autowired
    public void setChapterDao(ChapterDao chapterDao) {
        this.chapterDao = chapterDao;
    }

    @Override
    public List<ReadHistoryInfo> getHistoryList(Long userId) {
        List<ReadHistory> userAllHistory = readHistoryDao.getUserAllHistory(userId);
        List<ReadHistoryInfo> historyInfoList = new ArrayList<>();
        DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        for (ReadHistory history:
             userAllHistory) {
            ReadHistoryInfo historyInfo = new ReadHistoryInfo();
            BeanUtils.copyProperties(history,historyInfo);
            Book book = bookDao.getBookById(history.getBookId());
            Chapter chapter = chapterDao.getChapterInfoById(history.getChapterId());
            historyInfo.setAuthor(book.getAuthor());
            historyInfo.setBookTitle(book.getTitle());
            historyInfo.setCover(book.getCover());
            historyInfo.setDesc(book.getDesc());
            historyInfo.setChapterTitle(chapter.getTitle());
            historyInfo.setTime(dFormat.format(history.getTime()));
            historyInfoList.add(historyInfo);
        }
        return historyInfoList;
    }

    @Override
    public boolean deleteHistoryById(Long historyId) {
        if(readHistoryDao.deleteHistoryById(historyId) > 0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean deleteUserAllHistory(Long userId) {
        if(readHistoryDao.deleteUserAllHistory(userId) > 0){
            return true;
        }else {
            return false;
        }
    }
}
