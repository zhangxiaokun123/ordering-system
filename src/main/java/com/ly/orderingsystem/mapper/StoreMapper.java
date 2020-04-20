package com.ly.orderingsystem.mapper;

import com.ly.orderingsystem.entity.Store;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreMapper {

    Integer insert(Store store);

    Store selectById(Integer storeId);

    Integer update(Store store);
}
