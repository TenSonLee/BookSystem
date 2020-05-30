package com.jl.graduatedesign.service;

import com.jl.graduatedesign.entity.User;

public interface UserService {
    User login(String code,String password);
}
