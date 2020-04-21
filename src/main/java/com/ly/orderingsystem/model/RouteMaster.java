package com.ly.orderingsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RouteMaster {

    private Integer routeId;//线路Id

    private String routeName;//线路名称

    private String driverName;//司机姓名

    private String phoneNumber;//司机电话

    private String dcName;//配送中心名称
}
