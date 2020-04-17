package com.ly.orderingsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
/计量单位
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Unit {
/*    CREATE TABLE UNIT
            (
                    UNIT_ID              INT NOT NULL AUTO_INCREMENT,
                    UNIT_NAME            VARCHAR(4) NOT NULL,
    PRIMARY KEY (UNIT_ID)
);*/
    private Integer unitId;//单位id

    private String unitName;//单位名称
}
