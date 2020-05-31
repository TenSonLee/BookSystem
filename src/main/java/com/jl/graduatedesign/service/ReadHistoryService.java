package com.jl.graduatedesign.service;

import com.jl.graduatedesign.vo.ReadHistoryInfo;

import java.util.List;

public interface ReadHistoryService {
    List<ReadHistoryInfo> getHistoryList(Long userId);

    boolean deleteHistoryById(Long historyId);

    boolean deleteUserAllHistory(Long userId);
}
