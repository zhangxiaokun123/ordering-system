package com.ly.orderingsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Route {
 /*   CREATE TABLE ROUTE
            (
                    ROUTE_ID             INT NOT NULL AUTO_INCREMENT,
                    ROUTE_NAME           VARCHAR(20) NOT NULL,
    DRIVER_NAME          VARCHAR(6) NOT NULL,
    DRIVER_PHONENUMBER   VARCHAR(16) NOT NULL,
    DC_ID                INT NOT NULL,
    PRIMARY KEY (ROUTE_ID)
);*/
        private Integer routeId;//线路Id

        private String routeName;//线路名称

        private String driverName;//司机姓名

        private String phoneNumber;//司机电话

        private Integer dcId;//配送中心


}
