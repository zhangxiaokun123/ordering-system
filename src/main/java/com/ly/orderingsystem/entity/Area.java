package com.ly.orderingsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/*
/区域实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Area {
    private Integer areaId;//区域Id

    private String areaName;//区域名称

    private Integer cityId;//所属城市Id


}
