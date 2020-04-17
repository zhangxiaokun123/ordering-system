package com.ly.orderingsystem.model;

import lombok.Data;

import java.util.List;

/*
/分页专用类
 */

@Data
public class Page {
    private List<?> data;
    private Long total;
}
