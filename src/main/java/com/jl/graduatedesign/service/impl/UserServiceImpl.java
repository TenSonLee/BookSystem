package com.jl.graduatedesign.service.impl;

import com.jl.graduatedesign.dao.UserDao;
import com.jl.graduatedesign.entity.User;
import com.jl.graduatedesign.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
}
