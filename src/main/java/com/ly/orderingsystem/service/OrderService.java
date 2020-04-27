package com.ly.orderingsystem.service;

import javax.servlet.http.HttpSession;

public interface OrderService {
    String addOrder(HttpSession session);

    void updateOrderStatus(Long orderSn, Integer orderStatus);
}
