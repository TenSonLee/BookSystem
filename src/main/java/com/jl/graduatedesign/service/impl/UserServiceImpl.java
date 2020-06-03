package com.jl.graduatedesign.service.impl;

import com.jl.graduatedesign.dao.UserDao;
import com.jl.graduatedesign.entity.User;
import com.jl.graduatedesign.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User login(String code, String password) {
        return userDao.login(code,password);
    }

    @Override
    public List<User> getPagedUserList(Integer type,String code,String userName,Integer pageIndex, Integer pageSize) {
        return userDao.getPagedUserListByType(type,code,userName, pageIndex, pageSize);
    }

    @Override
    public int countByType(Integer type,String code,String userName) {
        return userDao.countUserByType(type,code,userName);
    }

    @Override
    public boolean deleteUserById(Long userId) {
        if(userDao.deleteUserById(userId) > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean resetPassById(Long userId) {
        if(userDao.resetPassById(userId) > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean register(User user) {
        return userDao.register(user)>0;
    }
}
