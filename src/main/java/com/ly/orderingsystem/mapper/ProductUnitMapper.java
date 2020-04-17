package com.ly.orderingsystem.mapper;

import com.ly.orderingsystem.entity.ProductUnit;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductUnitMapper {

    Integer inster(ProductUnit productUnit);

    Integer deleteProductUntilByCode(Integer productCode);

    Integer update(ProductUnit productUnit);

    List<ProductUnit> seleteByUnitId(Integer unitId);
}
