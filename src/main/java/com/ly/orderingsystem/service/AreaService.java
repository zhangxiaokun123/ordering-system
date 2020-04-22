package com.ly.orderingsystem.service;

import com.ly.orderingsystem.model.AreaMaster;
import com.ly.orderingsystem.model.Page;

public interface AreaService {
    Page getAreas(Integer page, Integer size);

    AreaMaster getArea(Integer areaId);

    String addArea(AreaMaster areaMaster);

    String updateArea(AreaMaster areaMaster);

    String deleteById(Integer areaId);
}
