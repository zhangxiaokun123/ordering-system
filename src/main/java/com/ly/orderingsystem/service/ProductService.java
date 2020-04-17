package com.ly.orderingsystem.service;

import com.ly.orderingsystem.entity.Product;
import com.ly.orderingsystem.entity.ProductUnit;
import com.ly.orderingsystem.model.Page;
import com.ly.orderingsystem.model.ProductMaster;

import java.util.List;
import java.util.Map;

public interface ProductService {
    Page getProducts(Integer page, Integer size);

    ProductMaster getProductByCode(Integer productCode);

    String addProduct(ProductMaster productMaster);

    String deleteProduct(Integer productCode);

    String updateProduct(ProductMaster productMaster);

    Page getProductsBySearch(Integer page, Integer size, Map<String, Object> searchParam);

    String updateStatus(Integer productCode, Integer status);
}
