package com.ly.orderingsystem.service;

import com.ly.orderingsystem.entity.StoreType;
import com.ly.orderingsystem.model.Page;

public interface StoreTypeService {
    Page getStoreTypes(Integer page, Integer size);

    StoreType getStoreType(Integer typeId);

    String addStoreType(StoreType storeType);

    String updateStoreType(StoreType storeType);

    String deleteStoreType(Integer typeId);
}
