package com.ly.orderingsystem.mapper;

import org.springframework.stereotype.Repository;

@Repository
public interface StoreTypeMapper {
    Integer selectIdByName(String storeType);
}
