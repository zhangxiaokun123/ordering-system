package com.ly.orderingsystem.controller;

import com.ly.orderingsystem.model.CartMaster;
import com.ly.orderingsystem.result.AjaxResult;
import com.ly.orderingsystem.result.ResultFactory;
import com.ly.orderingsystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    //根据购物车生成订单
    @RequestMapping("addOrder")
    public AjaxResult addOrder(HttpSession session){
        String msg=orderService.addOrder(session);
        return ResultFactory.buildFailResult(msg);
    }
    //根据订单编号修改订单状态
    @RequestMapping("updateOrderStatus")
    public void updateOrderStatus(@RequestParam Long orderSn,
                                  @RequestParam Integer orderStatus){
        orderService.updateOrderStatus(orderSn,orderStatus);
    }
}
