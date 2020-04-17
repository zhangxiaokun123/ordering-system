package com.ly.orderingsystem.service;

import com.ly.orderingsystem.entity.Unit;
import com.ly.orderingsystem.model.Page;

public interface UnitService {
    Page getUnits(Integer page, Integer size);

    Unit getUnit(Integer unitId);

    String addUnit(Unit unit);

    String updateById(Unit unit);

    String deleteById(Integer unitId);
}
