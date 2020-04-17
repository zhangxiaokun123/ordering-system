package com.ly.orderingsystem.controller;


import com.ly.orderingsystem.entity.Product;
import com.ly.orderingsystem.entity.ProductUnit;
import com.ly.orderingsystem.mapper.ProductMasterMapper;
import com.ly.orderingsystem.model.Page;
import com.ly.orderingsystem.model.ProductMaster;
import com.ly.orderingsystem.result.AjaxResult;
import com.ly.orderingsystem.result.ResultFactory;
import com.ly.orderingsystem.service.ProductService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(tags = "商品控制")
@RequestMapping("/product")

public class ProductController {
    /*
    /实现商品数据展现以及对商品的增加,删除,修改,查询等功能
     */
    @Autowired
    private ProductService productService;
    //获取所有商品信息,实现分页查询
@RequestMapping("/getProducts")
public Page getProducts(@RequestParam(defaultValue = "1") Integer page,
                        @RequestParam(defaultValue = "5") Integer size){
    return productService.getProducts(page, size);
}

    /*
    /实现新增商品信息
     */
    @RequestMapping("/addProduct")
    public AjaxResult addProduct(@RequestBody ProductMaster productMaster){
        String msg=productService.addProduct(productMaster);
       return ResultFactory.buildFailResult(msg);
    }


    /*
    /实现商品详情页面
     */
    @RequestMapping("/productInfo")
    public ProductMaster getProductByCode(@RequestParam("productCode") Integer productCode){
        return productService.getProductByCode(productCode);
    }

    /*+
    /根据productCode删除一个商品
     */
    @RequestMapping("/deleteProduct")
    public AjaxResult deleteProduct(@RequestParam Integer productCode){
        String msg=productService.deleteProduct(productCode);
        return ResultFactory.buildFailResult(msg);

    }

    /*
    /商品信息修改
     */
    @RequestMapping("/updateProduct")
    public AjaxResult updateProduct(@RequestParam Integer productCode,
                                    @RequestBody ProductMaster productMaster){
        productMaster.setProductCode(productCode);
        String msg=productService.updateProduct(productMaster);

        return ResultFactory.buildFailResult(msg);

    }
    /*
    /商品状态修改
     */
    @RequestMapping("/updateStatus")
    public AjaxResult updateStatus(@RequestParam Integer productCode,
                                   @RequestParam Integer status){
        String msg=productService.updateStatus(productCode,status);
        return ResultFactory.buildFailResult(msg);

    }

    /*
    /商品多搜索框功能实现
     */
    @RequestMapping("/getProductsBySearch")
     public Page getProductsBySearch(@RequestParam(defaultValue = "1") Integer page,
                                     @RequestParam(defaultValue = "5") Integer size,
                                     @RequestParam(defaultValue = "") Integer productCode,
                                     @RequestParam(defaultValue = "") String productName,
                                     @RequestParam(defaultValue = "") String categoryName,
                                     @RequestParam(defaultValue = "") String basicunitName,
                                     @RequestParam(defaultValue = "") String unitName){
          //利用map接收参数
           Map<String,Object> searchParam=new HashMap<>();
           searchParam.put("productCode",productCode);
           searchParam.put("productName",productName);
           searchParam.put("categoryName",categoryName);
           searchParam.put("basicunitName",basicunitName);
           searchParam.put("unitName",unitName);

           return productService.getProductsBySearch(page,size,searchParam);

     }
}
