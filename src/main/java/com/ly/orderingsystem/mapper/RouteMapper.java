package com.ly.orderingsystem.mapper;

import com.ly.orderingsystem.entity.Route;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteMapper {
    Integer selectIdByName(String routeName);

    Integer insert(Route route);

    Integer update(Route route);

    Integer deleteById(Integer routeId);

    List<Route> selectByDcId(Integer dcId);
}
