package com.ly.orderingsystem.mapper;

import com.ly.orderingsystem.entity.Cart;
import org.springframework.stereotype.Repository;

@Repository
public interface CartMapper {
    Integer insert(Cart cart);

    Cart selectByPU(Integer productCode, String userName);

    Integer updateByPU(Cart cart1);

    Integer delete(String userName, Integer productCode);

    void deleteByUserName(String userName);
}
