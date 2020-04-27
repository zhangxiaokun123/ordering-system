package com.ly.orderingsystem.mapper;

import com.ly.orderingsystem.entity.OrderMaster;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMasterMapper {
    Integer insert(OrderMaster orderMaster);

    void updateOrderStatus(Long orderSn, Integer orderStatus);
}
