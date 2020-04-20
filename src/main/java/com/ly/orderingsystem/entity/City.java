package com.ly.orderingsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/*
/城市实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {

    private Integer cityId;

    private String cityName;//城市名称
}
