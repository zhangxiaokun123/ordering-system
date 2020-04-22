package com.ly.orderingsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AreaMaster {
    private Integer areaId;//区域Id

    private String areaName;//区域名称

    private String cityName;//所属城市名称

}
