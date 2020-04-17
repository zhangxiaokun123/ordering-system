package com.ly.orderingsystem.service.imp;

import com.ly.orderingsystem.entity.Product;
import com.ly.orderingsystem.entity.ProductUnit;
import com.ly.orderingsystem.mapper.*;
import com.ly.orderingsystem.model.Page;
import com.ly.orderingsystem.model.ProductMaster;
import com.ly.orderingsystem.result.ResultFactory;
import com.ly.orderingsystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private ProductUnitMapper productUnitMapper;
    @Autowired
    private ProductMasterMapper productMasterMapper;
    @Autowired
    private UnitMapper unitMapper;

    @Override
    public Page getProducts(Integer page, Integer size) {

        Page pageEntity=new Page();
        //默认从零开始
        if (page != null && size != null) {
            page = (page-1)*size;
        }
        //获取当前商品信息
        List<ProductMaster> productMasters=productMasterMapper.getProducts(page,size);
        pageEntity.setData(productMasters);
        //获取当前商品总量
        Long total=productMasterMapper.getTotal();
        pageEntity.setTotal(total);
        return pageEntity;
    }


    @Override
    public ProductMaster getProductByCode(Integer productCode) {
        return productMasterMapper.selectByCode(productCode);
    }

    @Override
    @Transactional
    public String addProduct(ProductMaster productMaster) {
        //两次插入
        String b=productMaster.getBasicunitName();
        String u=productMaster.getUnitName();
        Integer productCode=productMaster.getProductCode();
        Integer d=productMaster.getDiscount();
        ProductUnit productUnit=new ProductUnit();
        productUnit.setProductCode(productCode);
        productUnit.setDiscount(d);
        productUnit.setBasicunitId(unitMapper.getIdByName(b));
        productUnit.setUnitId(unitMapper.getIdByName2(u));

        Product product=new Product(productMaster.getProductCode(),productMaster.getProductName(),
                productMaster.getProductDesc(),productMaster.getProductProviderid(),
                productMaster.getSupplyPrice(),productMaster.getImgInfo(),
                productMaster.getStatus(),categoryMapper.getIdByName(productMaster.getCategoryName()));

               Integer j=productMapper.inster(product);
               Integer i=productUnitMapper.inster(productUnit);
        if (i+j<2){
            String message=String.format("插入数据失败");
            return message;
        }else{
            String message=String.format("插入数据成功");
            return message;}
    }

    @Override
    @Transactional
    public String deleteProduct(Integer productCode) {
        Integer j=productMapper.deleteProductByCode(productCode);
        Integer i=productUnitMapper.deleteProductUntilByCode(productCode);
        if (i+j<2){
            String message=String.format("删除数据失败");
            return message;
        }else{
            String message=String.format("删除数据成功");
            return message;}
    }

    @Override
    @Transactional
    public String updateProduct(ProductMaster productMaster) {
        //两次修改
        String b=productMaster.getBasicunitName();
        String u=productMaster.getUnitName();
        Integer productCode=productMaster.getProductCode();
        Integer d=productMaster.getDiscount();
        ProductUnit productUnit=new ProductUnit();
        productUnit.setProductCode(productCode);
        productUnit.setDiscount(d);
        productUnit.setBasicunitId(unitMapper.getIdByName(b));
        productUnit.setUnitId(unitMapper.getIdByName2(u));

        Product product=new Product(productMaster.getProductCode(),productMaster.getProductName(),
                productMaster.getProductDesc(),productMaster.getProductProviderid(),
                productMaster.getSupplyPrice(),productMaster.getImgInfo(),
                productMaster.getStatus(),categoryMapper.getIdByName(productMaster.getCategoryName()));

        Integer j=productMapper.update(product);
        Integer i=productUnitMapper.update(productUnit);
        if (i+j<2){
            String message=String.format("修改数据失败");
            return message;
        }else{
            String message=String.format("修改数据成功");
            return message;}
    }

    @Override
    public Page getProductsBySearch(Integer page, Integer size, Map<String, Object> searchParam) {
        Page pageEntity=new Page();
        //默认从零开始
        if (page != null && size != null) {
            page = (page-1)*size;
        }
        searchParam.put("page",page);
        searchParam.put("size",size);
        //获取当前商品信息
        List<ProductMaster> productMasters=productMasterMapper.selectByParam(searchParam);
        pageEntity.setData(productMasters);
        //获取当前商品总量
        Long total=productMasterMapper.getTotalByParam(searchParam);
        pageEntity.setTotal(total);
        return pageEntity;
    }

    @Override
    public String updateStatus(Integer productCode, Integer status) {
        Integer i=productMapper.updateStatus(productCode,status);
        if (i<1){
            String message=String.format("修改数据失败");
            return message;
        }else{
            String message=String.format("修改数据成功");
            return message;}
    }

}
