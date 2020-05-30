package com.jl.graduatedesign.dao;

import com.jl.graduatedesign.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    User login(String code,String password);
}
