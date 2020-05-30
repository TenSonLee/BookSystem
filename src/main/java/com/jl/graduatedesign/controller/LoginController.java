package com.jl.graduatedesign.controller;

import com.jl.graduatedesign.entity.User;
import com.jl.graduatedesign.service.UserService;
import com.jl.graduatedesign.vo.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/login")
    public CommonResponse login(@RequestBody User user){
        User returnUser = userService.login(user.getCode(),user.getPassword());
        CommonResponse commonResponse = null;
        if(returnUser!=null) {
            commonResponse = new CommonResponse("0", "登录成功", returnUser);
        }else {
            commonResponse = new CommonResponse("200", "用户名或密码错误", null);
        }
        return commonResponse;
    }
}
