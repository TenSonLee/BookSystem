package com.jl.graduatedesign.service;

import com.jl.graduatedesign.entity.User;

import java.util.List;

public interface UserService {
    User login(String code,String password);

    List<User> getPagedUserList(Integer type,String code,String userName,Integer pageIndex,Integer pageSize);

    int countByType(Integer type,String code,String userName);

    boolean deleteUserById(Long userId);

    boolean resetPassById(Long userId);

    boolean register(User user);
}
