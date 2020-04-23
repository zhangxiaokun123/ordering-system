package com.ly.orderingsystem.controller;

import com.ly.orderingsystem.entity.User;
import com.ly.orderingsystem.result.AjaxResult;
import com.ly.orderingsystem.result.ResultFactory;
import com.ly.orderingsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
