package com.ly.orderingsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {
  /*  CREATE TABLE PRODUCT
            (
                    PRODUCT_CODE         BIGINT NOT NULL,
                    PRODUCT_NAME         VARCHAR(10) NOT NULL,
    PRODUCT_DESC         VARCHAR(10),
    CATEGORY_ID          INT NOT NULL,
    PRODUCT_PROVIDERID   INT NOT NULL,
    SUPPLY_PRICE         DECIMAL(4,2) NOT NULL,
    IMG_INFO             VARCHAR(100),
    STATUS               TINYINT NOT NULL,
    PRIMARY KEY (PRODUCT_CODE)
);*/
    private Integer productCode;//商品编码

    private String productName;//商品名称

    private  String productDesc;//商品描述

    private  Integer productProviderid;

    private Double supplyPrice;//商品价格

    private String imgInfo;//商品图片

    private Integer status;//商品状态

    private Integer categoryId;

}
