package com.ly.orderingsystem.mapper;

import com.ly.orderingsystem.entity.Product;
import com.ly.orderingsystem.model.ProductMaster;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ProductMasterMapper {
    ProductMaster selectByCode(Integer productCode);

    List<ProductMaster> getProducts(Integer page, Integer size);

    Long getTotal();

    List<ProductMaster> selectByParam(Map<String, Object> searchParam);

    Long getTotalByParam(Map<String, Object> searchParam);
}

