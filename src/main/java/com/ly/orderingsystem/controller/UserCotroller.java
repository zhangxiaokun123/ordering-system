package com.ly.orderingsystem.controller;

import com.ly.orderingsystem.entity.User;
import com.ly.orderingsystem.result.AjaxResult;
import com.ly.orderingsystem.result.ResultFactory;
import com.ly.orderingsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserCotroller {
    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public AjaxResult register(@RequestBody User user){
        String msg=userService.register(user);
        return ResultFactory.buildFailResult(msg);
    }
    //用户登录
    @RequestMapping("/login")
    public  AjaxResult login(@RequestParam String userName,
                             @RequestParam String passWord,
                             HttpSession session){
        String msg=userService.login(userName,passWord,session);
        return ResultFactory.buildFailResult(msg);
    }

    //用户修改密码
    @RequestMapping("/update")
    public AjaxResult update(@RequestParam String userName,
                             @RequestParam String passWord){
        String msg=userService.update(userName,passWord);
        return ResultFactory.buildFailResult(msg);
    }


}
