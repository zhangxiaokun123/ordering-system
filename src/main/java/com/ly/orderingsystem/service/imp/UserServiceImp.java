package com.ly.orderingsystem.service.imp;

import com.ly.orderingsystem.entity.User;
import com.ly.orderingsystem.mapper.UserMapper;
import com.ly.orderingsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public String register(User user) {
        //先查询用户名是否存在
        User user1=userMapper.selectByUserName(user.getUserName());
        System.out.println(user1);
        if (user1!=null){
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

    @Override
    public String login(String userName, String passWord, HttpSession session) {
        User user=userMapper.selectByUserName(userName);
        if (user!=null){
            if (user.getPassWord().equals(passWord)){
                    session.setAttribute("userName",userName);
                    String msg=String.format("登录成功");
                    return msg;
            }else {
                String msg=String.format("登录失败,密码不正确");
                return msg;
            }
        }else {
            String msg = String.format("登录失败,用户名不存在");
            return msg;
        }
    }

    @Override
    public String update(String userName, String passWord) {
        Integer i=userMapper.update(userName,passWord);
        if (i>0){
            String msg=String.format("修改成功");
            return msg;
        }else {
            String msg=String.format("修改失败");
            return msg;
        }
    }
}
