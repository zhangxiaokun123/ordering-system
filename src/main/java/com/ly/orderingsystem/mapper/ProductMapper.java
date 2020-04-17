package com.ly.orderingsystem.mapper;

import com.ly.orderingsystem.entity.Product;
import com.ly.orderingsystem.model.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper {

    Integer inster(Product product);

    Integer deleteProductByCode(Integer productCode);

    Integer update(Product product);

    List<Product> selectByCategoryId(Integer categoryId);

    Integer updateStatus(@Param("productCode") Integer productCode, @Param("status") Integer status);
}
