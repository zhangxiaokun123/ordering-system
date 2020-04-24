package com.ly.orderingsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartMaster {
    private Integer id;//ID

    private String userName;//用户名

    private Integer productCode;//商品编码

    private Integer productNumber;//商品数量

    private Integer status;//状态

    private String createTime;//创建时间

    private String modifiedTime;//最后修改时间

    private String productName;//商品名称

    private  String productDesc;//商品描述

    private Double supplyPrice;//商品价格

    private String imgInfo;//商品图片

    private String basicunitName;//基本单位

    private String unitName;//供货单位

    private Integer discount;//折算系数

    private String categoryName;//分类名称

}
