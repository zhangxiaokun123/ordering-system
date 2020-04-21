package com.ly.orderingsystem.mapper;

import com.ly.orderingsystem.entity.StoreType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreTypeMapper {
    Integer selectIdByName(String storeType);

    List<StoreType> selectAll(Integer page, Integer size);

    Long getTotal();

    StoreType selectIdById(Integer typeId);

    Integer insert(StoreType storeType);

    Integer update(StoreType storeType);

    Integer deleteById(Integer typeId);
}
