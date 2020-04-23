package com.ly.orderingsystem.service.imp;

import com.ly.orderingsystem.entity.User;
import com.ly.orderingsystem.mapper.UserMapper;
import com.ly.orderingsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public String register(User user) {
        //先查询用户名是否存在
        List<User> users=userMapper.selectByUserName(user.getUserName());
        System.out.println(user);
        if (users.size()>0){
            String msg=String.format("/用户名已存在");
            return msg;
        }else {
            Integer i=userMapper.insert(user);
            if (i>0){
                String msg=String.format("/注册成功");
                return msg;
            }else {
                String msg=String.format("/注册失败");
                return msg;
            }
        }
    }
}
