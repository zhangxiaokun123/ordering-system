package com.ly.orderingsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
/商品计量单位关系
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductUnit {
   /* CREATE TABLE PRODUCT_UNIT
            (
                    PRODUCT_CODE         BIGINT NOT NULL,
                    BASICUNIT_ID         INT NOT NULL,
                    UNIT_ID              INT NOT NULL,
                    DISCOUNT             INT NOT NULL
            );*/

    private  Integer productCode;//商品编码

    private Integer basicunitId;//基本单位id

    private Integer unitId;//供货单位id

    private Integer discount;//折算系数




}
