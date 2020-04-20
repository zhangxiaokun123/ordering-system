package com.ly.orderingsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/*
/门店类型实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreType {
 /*   CREATE TABLE STORE_TYPE
            (
                    TYPE_ID              INT NOT NULL AUTO_INCREMENT,
                    TYPE_NAME            VARCHAR(10) NOT NULL,
    PRIMARY KEY (TYPE_ID)
);*/


        private Integer typeId;//门店类型Id


        private Integer typeName;//类型名称
}
