package com.jl.graduatedesign.dao;

import com.jl.graduatedesign.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    User login(String code,String password);

    String getUserNameById(Long userId);

    List<User> getAllUserByType(Integer type);

    List<User> getPagedUserListByType(Integer type,String code,String userName,Integer pageIndex,Integer pageSize);

    int countUserByType(Integer type,String code,String userName);

    int deleteUserById(Long userId);

    int resetPassById(Long userId);

    int register(User user);
}
