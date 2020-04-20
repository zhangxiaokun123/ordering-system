package com.ly.orderingsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/*
/配送中心实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DistributionCenter {

 /*   CREATE TABLE DISTRIBUTION_CENTER
            (
                    DC_ID                INT NOT NULL AUTO_INCREMENT,
                    DC_NAME              VARCHAR(20) NOT NULL,
    ADRESS               VARCHAR(30) NOT NULL,
    HEAD_NAME            VARBINARY(10) NOT NULL,
    PHONE_NUMBER         VARCHAR(16) NOT NULL,
    PRIMARY KEY (DC_ID)
);*/


        private Integer dcId;//配送中心ID

        private String dcName;//配送中心名称

        private String adress;//配送中心地址

        private String headName;//中心负责人

        private String phoneNumber;//联系方式
}
