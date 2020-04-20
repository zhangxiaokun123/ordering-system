package com.ly.orderingsystem.entity;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
/门店实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Store {

/*
    CREATE TABLE STORE
            (
                    STORE_ID             INT NOT NULL,
                    STORE_NAME           VARCHAR(20) NOT NULL,
    AREA                 VARCHAR(10) NOT NULL,
    ADRESS               VARCHAR(30) NOT NULL,
    ROUTE_ID             INT NOT NULL,
    SRORE_TYPE           INT NOT NULL,
    STATUS               TINYINT NOT NULL,
    PRIMARY KEY (STORE_ID)
);
*/
        private Integer storeId;//门店编号

        private String storeName;//门店名称

        private String area;//所属区域

        private Integer address;//门店地址

        private Integer roteId;//路线ID

        private Integer sroreType;//门店类型

        private Integer status;//门店状态

}
