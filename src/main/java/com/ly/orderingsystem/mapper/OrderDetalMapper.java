package com.ly.orderingsystem.mapper;

import com.ly.orderingsystem.entity.OrderDetail;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetalMapper {
    void insert(OrderDetail orderDetail);
}
