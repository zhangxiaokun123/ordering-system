package com.ly.orderingsystem.mapper;

import com.ly.orderingsystem.model.CartMaster;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartMasterMapper {
    List<CartMaster> selectAll(String userName);
}
