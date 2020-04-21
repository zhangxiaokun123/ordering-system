package com.ly.orderingsystem.service;

import com.ly.orderingsystem.model.Page;
import com.ly.orderingsystem.model.StoreMaster;

import java.util.Map;

public interface StoreService {
    Page getStores(Integer page, Integer size);

    StoreMaster getStoreById(Integer storeId);

    String addStore(StoreMaster storeMaster);

    String update(StoreMaster storeMaster);

    String deleteById(Integer storeId);

    Page selectBySearch(Integer page, Integer size, Map<String, Object> searchParam);
}
