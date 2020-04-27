package com.ly.orderingsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail {
/*
    CREATE TABLE ORDER_DETAIL
            (
                    ORDER_SN             BIGINT NOT NULL ,
                    PRODUCT_CODE         BIGINT NOT NULL,
                    PRODUCT_CNT          INT NOT NULL DEFAULT 0,
                    ORDER_MONEY          DEC(8,2) NOT NULL,
                    PRODUCT_NAME         VARCHAR(20) NOT NULL,
    PRIMARY KEY (ORDER_SN)
);
*/

    private Long orderSn;//订单编号

    private Integer productCode;//商品编码

    private Integer productCnt;//商品数量

    private Double orderMoney;//商品金额

    private String productName;//商品名称

}
