package com.ly.orderingsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/*
/分类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    /*CREATE TABLE CATEGORY
            (
                    CATEGORY_ID          INT NOT NULL AUTO_INCREMENT,
                    CATEGORY_NAME        VARCHAR(10) NOT NULL,
    PRIMARY KEY (CATEGORY_ID)
);*/

    private Integer categoryId;//分类ID

    private String categoryName;//分类名称



}
