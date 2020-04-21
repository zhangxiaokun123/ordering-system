package com.ly.orderingsystem.mapper;

import com.ly.orderingsystem.model.RouteMaster;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface RouteMasterMapper {
    List<RouteMaster> selectAll(Integer page, Integer size);

    Long getTotal();

    RouteMaster selectById(Integer routeId);

    List<RouteMaster> getRoutesBySearch(Map<String, Object> searchParam);

    Long getTotalBySearch(Map<String, Object> searchParam);
}
