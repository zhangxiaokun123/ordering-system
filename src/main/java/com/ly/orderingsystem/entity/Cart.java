package com.ly.orderingsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
/*    CREATE TABLE SHOPPING_CART
            (
                    ID                   INT NOT NULL AUTO_INCREMENT,
                    USER_NAME            VARCHAR(50) NOT NULL,
    PRODUCT_CODE         BIGINT NOT NULL,
    PRODUCT_NUMBER       INT NOT NULL,
    STATUS               TINYINT NOT NULL,
    CREATE_TIME          TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    MODIFIED_TIME        TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (ID)
);*/
            private Integer id;//ID

            private String userName;//用户名

            private Integer productCode;//商品编码

            private Integer productNumber;//商品数量

            private Integer status;//状态

            private String createTime;//创建时间

            private String modifiedTime;//最后修改时间



}
