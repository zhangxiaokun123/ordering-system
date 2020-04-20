package com.ly.orderingsystem.mapper;

import org.springframework.stereotype.Repository;

@Repository
public interface AreaMapper {
    Integer selectIdByName(String areaName);
}
