package com.ly.orderingsystem.mapper;

import org.springframework.stereotype.Repository;

@Repository
public interface RouteMapper {
    Integer selectIdByName(String routeName);
}
