package com.ly.orderingsystem.service;

import com.ly.orderingsystem.model.Page;
import com.ly.orderingsystem.model.StoreMaster;

public interface StoreService {
    Page getStores(Integer page, Integer size);

    StoreMaster getStoreById(Integer storeId);

    String addStore(StoreMaster storeMaster);

    String update(StoreMaster storeMaster);
}
