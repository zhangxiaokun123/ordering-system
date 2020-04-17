package com.ly.orderingsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductMaster {

    private Integer productCode;

    private String categoryName;//分类名称

    private String productName;//商品名称

    private  String productDesc;//商品描述

    private  Integer productProviderid; //供应商ID

    private String basicunitName;//基本单位

        private String unitName;//供货单位

    private Integer discount;//折算系数

    private Double supplyPrice;//商品价格

    private String imgInfo;//商品图片

    private Integer status;//商品状态


}
