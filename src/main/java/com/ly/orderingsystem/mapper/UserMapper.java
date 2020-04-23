package com.ly.orderingsystem.mapper;

import com.ly.orderingsystem.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {


    Integer insert(User user);

    List<User> selectByUserName(String userName);

}
