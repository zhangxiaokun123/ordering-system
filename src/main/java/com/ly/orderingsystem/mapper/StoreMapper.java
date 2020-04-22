package com.ly.orderingsystem.mapper;

import com.ly.orderingsystem.entity.Store;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreMapper {

    Integer insert(Store store);

    Store selectById(Integer storeId);

    Integer update(Store store);

    Integer deleteById(Integer storeId);

    List<Store> selectByRouteId(Integer routeId);

    List<Store> selectByTypeId(Integer typeId);

    List<Store> selectByAreaId(Integer areaId);
}
