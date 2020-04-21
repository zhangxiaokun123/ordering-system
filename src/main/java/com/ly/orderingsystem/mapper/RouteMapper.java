package com.ly.orderingsystem.mapper;

import com.ly.orderingsystem.entity.Route;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteMapper {
    Integer selectIdByName(String routeName);

    Integer insert(Route route);

    Integer update(Route route);

    Integer deleteById(Integer routeId);
}
