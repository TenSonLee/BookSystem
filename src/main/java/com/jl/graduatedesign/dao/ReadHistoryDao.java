package com.jl.graduatedesign.dao;

import com.jl.graduatedesign.entity.ReadHistory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReadHistoryDao {
    ReadHistory getHistoryByBookAndUserId(Long bookId,Long userId);

    int insertHistory(ReadHistory readHistory);

    int updateHistory(ReadHistory readHistory);

    int deleteHistory(Long userId,Long bookId);

    int deleteHistoryById(Long historyId);

    int deleteUserAllHistory(Long userId);

    List<ReadHistory> getUserAllHistory(Long userId);
}
