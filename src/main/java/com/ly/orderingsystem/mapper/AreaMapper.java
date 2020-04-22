package com.ly.orderingsystem.mapper;

import com.ly.orderingsystem.entity.Area;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreaMapper {
    Integer selectIdByName(String areaName);

    List<Area> selectIdByCityId(Integer cityId);

    Integer insert(Area area);

    Integer update(Area area);

    Integer deleteById(Integer areaId);
}
