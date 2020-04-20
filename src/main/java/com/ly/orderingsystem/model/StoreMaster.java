package com.ly.orderingsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreMaster {

    private Integer storeId;//门店编号

    private String storeName;//门店名称

    private String areaName;//区域名称

    private String address;//门店地址

    private String routeName;//线路名称

    private String storeType;//门店类型

    private Integer status;//门店状态
}
