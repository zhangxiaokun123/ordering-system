package com.ly.orderingsystem.mapper;

import com.ly.orderingsystem.entity.City;
import com.ly.orderingsystem.model.AreaMaster;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreaMasterMapper {
    List<City> seletAll(Integer page, Integer size);

    Long getTotal();

    AreaMaster selectById(Integer areaId);
}
