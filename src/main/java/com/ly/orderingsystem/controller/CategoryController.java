package com.ly.orderingsystem.controller;

import com.ly.orderingsystem.entity.Category;
import com.ly.orderingsystem.model.Page;
import com.ly.orderingsystem.result.AjaxResult;
import com.ly.orderingsystem.result.ResultFactory;
import com.ly.orderingsystem.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*
/实现分类信息的增删改查
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    //获取所有分类信息
    @RequestMapping("/getCategorys")
    public Page getCategorys(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "5") Integer size){
          return categoryService.getCategorys(page,size);
    }
    //查询单个分类信息
    @RequestMapping("/getCategory")
    public Category getCategory(@RequestParam Integer categoryId){
        return categoryService.getCategory(categoryId);
    }

    //添加分类
    @RequestMapping("/addCategory")
    public AjaxResult addCategory(@RequestBody Category category){
        String msg=categoryService.addCategory(category);
        return ResultFactory.buildFailResult(msg);
    }

    //修改分类
    @RequestMapping("/updateCategory")
    public AjaxResult updateCategory(@RequestParam Integer categoryId,
                                     @RequestBody Category category){
        category.setCategoryId(categoryId);
        String msg=categoryService.updateCategory(category);
        return ResultFactory.buildFailResult(msg);
    }


    //删除分类
    @RequestMapping("/deleteCategory")
    public AjaxResult deleteCategory(@RequestParam Integer categoryId){
        String msg=categoryService.deleteCategory(categoryId);
        return ResultFactory.buildFailResult(msg);
    }
}
