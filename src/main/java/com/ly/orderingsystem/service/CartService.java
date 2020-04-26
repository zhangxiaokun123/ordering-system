package com.ly.orderingsystem.service;

import com.ly.orderingsystem.model.CartMaster;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface CartService {
    String addCart(Integer productCode, Integer productNumber, HttpSession session);

    void updateProductNumber(Integer productCode, Integer productNumber, HttpSession session);

    List<CartMaster> getCarts(HttpSession session);

    String deleteCart(Integer productCode, HttpSession session);
}
