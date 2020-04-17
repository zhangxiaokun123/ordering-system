package com.ly.orderingsystem;

import com.ly.orderingsystem.entity.ProductUnit;
import com.ly.orderingsystem.mapper.ProductUnitMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrderingSystemApplicationTests {
  @Autowired
  ProductUnitMapper productUnitMapper;
   /* @Test
    void contextLoads() {
        ProductUnit productUnit=new ProductUnit();
        productUnit.setProductCode(8);
        productUnit.setBasicunitId(2);
        productUnit.setUnitId(1);
        productUnit.setDiscount(1);
        productUnitMapper.insterProductUnit(productUnit);
    }*/
}
