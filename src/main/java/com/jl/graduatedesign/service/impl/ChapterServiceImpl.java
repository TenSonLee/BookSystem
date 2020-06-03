package com.jl.graduatedesign.service.impl;

import com.jl.graduatedesign.dao.BookDao;
import com.jl.graduatedesign.dao.ChapterDao;
import com.jl.graduatedesign.dao.ReadHistoryDao;
import com.jl.graduatedesign.entity.Chapter;
import com.jl.graduatedesign.entity.ReadHistory;
import com.jl.graduatedesign.service.ChapterService;
import com.jl.graduatedesign.vo.PagedChapterSearchCondition;
import com.jl.graduatedesign.vo.ReadChapterData;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Component
public class ChapterServiceImpl implements ChapterService {
    private ChapterDao chapterDao;

    private BookDao bookDao;

    private ReadHistoryDao readHistoryDao;

    @Autowired
    public void setChapterDao(ChapterDao chapterDao) {
        this.chapterDao = chapterDao;
    }

    @Autowired
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Autowired
    public void setReadHistoryDao(ReadHistoryDao readHistoryDao) {
        this.readHistoryDao = readHistoryDao;
    }

    @Override
    public List<Chapter> getChapterList(Long bookId) {
        return chapterDao.queryChapterListByBookId(bookId);
    }

    @Override
    public ReadChapterData readChapter(Long userId, Long chapterId) {
        Chapter chapter = chapterDao.getChapterInfoById(chapterId);
        ReadChapterData readChapterData = new ReadChapterData();

        BeanUtils.copyProperties(chapter,readChapterData);
        readChapterData.setChapterTitle(chapter.getTitle());
        readChapterData.setBookTitle(bookDao.getBookById(chapter.getBookId()).getTitle());
        readChapterData.setContent(chapterDao.getContent(chapterId));

        Chapter prevChapter = chapterDao.getChapterByBookIdAndSeries(chapter.getBookId(),chapter.getSeries()-1);
        if(prevChapter == null) {
            readChapterData.setPrevChapterId(null);
            readChapterData.setFirstChapter(true);
        }else {
            readChapterData.setPrevChapterId(prevChapter.getChapterId());
            readChapterData.setFirstChapter(false);
        }

        Chapter nextChapter = chapterDao.getChapterByBookIdAndSeries(chapter.getBookId(),chapter.getSeries()+1);
        if(nextChapter == null) {
            readChapterData.setNextChapterId(null);
            readChapterData.setLastChapter(true);
        }else {
            readChapterData.setNextChapterId(nextChapter.getChapterId());
            readChapterData.setLastChapter(false);
        }

        //添加或修改阅读记录
        ReadHistory readHistory = readHistoryDao.getHistoryByBookAndUserId(chapter.getBookId(), userId);
        if(null == readHistory){
            readHistory = new ReadHistory();
            BeanUtils.copyProperties(chapter,readHistory);
            readHistory.setUserId(userId);
            readHistory.setTime(new Date());
            readHistoryDao.insertHistory(readHistory);
        }else {
            readHistory.setChapterId(chapter.getChapterId());
            readHistory.setTime(new Date());
            readHistoryDao.updateHistory(readHistory);
        }

        return readChapterData;
    }

    @Override
    public Chapter getChapterByBookIdAndSeries(Long bookId, Integer series) {
        return chapterDao.getChapterByBookIdAndSeries(bookId,series);
    }

    @Override
    public List<Chapter> getPagedChapterListByCondition(PagedChapterSearchCondition condition) {
        return chapterDao.getPagedChapterListByCondition(condition);
    }

    @Override
    public int countChapterByCondition(PagedChapterSearchCondition condition) {
        return chapterDao.countChapterByCondition(condition);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addNewChapter(Chapter chapter) throws Exception {
        chapter.setWords(chapter.getContent().length());
        if(chapterDao.insertChapter(chapter)>0) {
            System.out.println(chapter);
            if(chapterDao.insertContent(chapter)>0){
                return true;
            }
        }
        throw new Exception("插入章节失败");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateChapter(Chapter chapter) throws Exception {
        chapter.setWords(chapter.getContent().length());
        if(chapterDao.updateChapter(chapter)>0) {
            System.out.println(chapter);
            if(chapterDao.updateContent(chapter)>0){
                return true;
            }
        }
        throw new Exception("更新章节失败");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteChapterById(Long chapterId) throws Exception {
        if(chapterDao.deleteContent(chapterId)>0) {
            if(chapterDao.deleteChapter(chapterId)>0){
                return true;
            }
        }
        throw new Exception("删除章节失败");
    }
}
