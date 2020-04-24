package com.ly.orderingsystem.controller;

import com.ly.orderingsystem.model.CartMaster;
import com.ly.orderingsystem.result.AjaxResult;
import com.ly.orderingsystem.result.ResultFactory;
import com.ly.orderingsystem.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    /*
    /购物车功能实现
     */
    //向购物车添加一条商品
    @RequestMapping("addCart")
    public AjaxResult addCart(@RequestParam Integer productCode,
                              @RequestParam Integer productNumber,
                              HttpSession session){
        String msg=cartService.addCart(productCode,productNumber,session);
        return ResultFactory.buildFailResult(msg);
    }

    //实时更新购物车种商品的数量
    @RequestMapping("updateProductNumber")
    public void updateProductNumber(@RequestParam Integer productCode,
                              @RequestParam Integer productNumber,
                              HttpSession session){
        cartService.updateProductNumber(productCode,productNumber,session);
    }

    //获取购物车详情页面
 @RequestMapping("getCarts")
    public List<CartMaster> getCarts(HttpSession session){
        return cartService.getCarts(session);
    }
}
