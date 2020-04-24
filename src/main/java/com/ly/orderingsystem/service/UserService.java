package com.ly.orderingsystem.service;

import com.ly.orderingsystem.entity.User;

import javax.servlet.http.HttpSession;

public interface UserService {
    String register(User user);

    String login(String userName, String passWord, HttpSession session);

    String update(String userName, String passWord);
}
