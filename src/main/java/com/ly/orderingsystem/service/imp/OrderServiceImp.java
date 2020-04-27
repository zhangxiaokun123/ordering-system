package com.ly.orderingsystem.service.imp;

import com.ly.orderingsystem.entity.OrderDetail;
import com.ly.orderingsystem.entity.OrderMaster;
import com.ly.orderingsystem.mapper.*;
import com.ly.orderingsystem.model.CartMaster;
import com.ly.orderingsystem.service.OrderService;
import com.ly.orderingsystem.utils.RecordNoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class OrderServiceImp implements OrderService {
    @Autowired
    private CartMasterMapper cartMasterMapper;
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private OrderMasterMapper orderMasterMapper;
    @Autowired
    private OrderDetalMapper orderDetalMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public String addOrder(HttpSession session) {
        Object userObj=session.getAttribute("userName");
        String userName=userObj.toString();
        //生成订单编号
        RecordNoUtils recordNoUtils=new RecordNoUtils();
        Long orderSn=recordNoUtils.getSN();
        double orderMoney=0;
        //先获取购物车中的商品信息
        List<CartMaster> cartMasters=cartMasterMapper.selectAll(userName);
        for (CartMaster cartMaster:cartMasters) {
            OrderDetail orderDetail=new OrderDetail();
            orderDetail.setOrderSn(orderSn);
            orderDetail.setOrderMoney(cartMaster.getSupplyPrice());
            orderDetail.setProductCnt(cartMaster.getProductNumber());
            orderDetail.setProductCode(cartMaster.getProductCode());
            orderDetail.setProductName(cartMaster.getProductName());
            //向订单商品详情表里插入数据
            orderDetalMapper.insert(orderDetail);
            orderMoney=orderMoney+cartMaster.getSupplyPrice();
        }
        //生成订单总表,并插入
        OrderMaster orderMaster=new OrderMaster();
        orderMaster.setOrderSn(orderSn);
        orderMaster.setPaymentMethod(0);
        orderMaster.setUserName(userName);
        orderMaster.setUname(userMapper.selectByUserName(userName).getUname());
        orderMaster.setOrderStatus(0);
        orderMaster.setOrderMoney(orderMoney);
        Integer i=orderMasterMapper.insert(orderMaster);
        //成功生成订单后同时删除购物车中的信息
        cartMapper.deleteByUserName(userName);
        if (i>0){
            String msg=String.format("成功生成订单");
            return msg;
        }else {
            String msg=String.format("生成订单失败");
            return msg;
        }
    }

    @Override
    public void updateOrderStatus(Long orderSn, Integer orderStatus) {
        orderMasterMapper.updateOrderStatus(orderSn,orderStatus);
    }
}
