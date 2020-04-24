package com.ly.orderingsystem.service.imp;

import com.ly.orderingsystem.entity.Cart;
import com.ly.orderingsystem.entity.User;
import com.ly.orderingsystem.mapper.CartMapper;
import com.ly.orderingsystem.mapper.CartMasterMapper;
import com.ly.orderingsystem.model.CartMaster;
import com.ly.orderingsystem.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class CartServiceImp implements CartService {
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private CartMasterMapper cartMasterMapper;
    @Override
    public String addCart(Integer productCode, Integer productNumber, HttpSession session) {
        //先判断是否为登录状态,未登录不可添加商品
        Object userObj=session.getAttribute("userName");
        String userName=userObj.toString();
        if (userObj!=null){
            //如果购物车中已存在该商品则只增加商品数量
            Cart cart1=cartMapper.selectByPU(productCode,userName);
            if(cart1!=null) {
                Integer i = cart1.getProductNumber();
                productNumber = productNumber + i;
                cart1.setProductCode(productCode);
                cart1.setProductNumber(productNumber);
                cart1.setUserName(userName);
                Integer j = cartMapper.updateByPU(cart1);
                if (j > 0) {
                    String msg = String.format("已成功将商品添加到购物车");
                    return msg;
                } else {
                    String msg = String.format("添加失败");
                    return msg;
                }
            }else {
                Cart cart = new Cart();
                cart.setProductCode(productCode);
                cart.setProductNumber(productNumber);
                cart.setUserName(userName);
                //向购物车插入一条数据
                Integer i = cartMapper.insert(cart);
                if (i > 0) {
                    String msg = String.format("已成功将商品添加到购物车");
                    return msg;
                } else {
                    String msg = String.format("添加失败");
                    return msg;
                }
            }
        }else {
            String msg=String.format("请先登录");
            return msg;
        }
    }

    @Override
    public void updateProductNumber(Integer productCode, Integer productNumber, HttpSession session) {
        Object userObj=session.getAttribute("userName");
        String userName=userObj.toString();
        Cart cart=new Cart();
        cart.setUserName(userName);
        cart.setProductCode(productCode);
        cart.setProductNumber(productNumber);
        cartMapper.updateByPU(cart);
    }

    @Override
    public List<CartMaster> getCarts(HttpSession session) {
        Object userObj=session.getAttribute("userName");
        String userName=userObj.toString();
        return cartMasterMapper.selectAll(userName);
    }


}
