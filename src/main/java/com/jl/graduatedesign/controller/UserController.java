package com.jl.graduatedesign.controller;

import com.jl.graduatedesign.entity.User;
import com.jl.graduatedesign.service.UserService;
import com.jl.graduatedesign.vo.CommonResponse;
import com.jl.graduatedesign.vo.PagedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/getPagedUserList")
    public PagedResponse getPagedUserList(Integer type,String code,String userName,Integer pageIndex,Integer pageSize){
        int count = userService.countByType(type,code,userName);
        List<User> userList = userService.getPagedUserList(type,code,userName,pageIndex, pageSize);
        PagedResponse<User> pagedResponse = new PagedResponse<>();
        pagedResponse.setRel(true);
        pagedResponse.setMsg("操作成功");
        pagedResponse.setList(userList);
        pagedResponse.setCount(count);
        return pagedResponse;
    }

    @RequestMapping(value = "/deleteUserById")
    public CommonResponse deleteUserById(Long userId){
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setCode("-1");
        commonResponse.setMsg("操作失败");
        if(userService.deleteUserById(userId)){
            commonResponse.setCode("0");
            commonResponse.setMsg("操作成功");
        };
        return commonResponse;
    }

    @RequestMapping(value = "/resetPassById")
    public CommonResponse resetPassById(Long userId){
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setCode("-1");
        commonResponse.setMsg("操作失败");
        if(userService.resetPassById(userId)){
            commonResponse.setCode("0");
            commonResponse.setMsg("操作成功");
        };
        return commonResponse;
    }

    @RequestMapping(value = "/register")
    public CommonResponse register(User user){
        CommonResponse commonResponse = new CommonResponse();
        System.out.println(user);

        if(userService.register(user)) {
            commonResponse.setCode("0");
            commonResponse.setMsg("注册成功");
        }else {
            commonResponse.setCode("-1");
            commonResponse.setMsg("用户账号已存在!");
        }

        return commonResponse;
    }
}
