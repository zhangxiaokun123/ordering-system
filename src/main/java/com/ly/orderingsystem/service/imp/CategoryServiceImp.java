package com.ly.orderingsystem.service.imp;

import com.ly.orderingsystem.entity.Category;
import com.ly.orderingsystem.entity.Product;
import com.ly.orderingsystem.mapper.CategoryMapper;
import com.ly.orderingsystem.mapper.ProductMapper;
import com.ly.orderingsystem.model.Page;
import com.ly.orderingsystem.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private ProductMapper productMapper;
    @Override
    public Page getCategorys(Integer page, Integer size) {
        Page pageEntity=new Page();
        //默认从零开始
        if (page != null && size != null) {
            page = (page-1)*size;
        }
        //获取当前分类信息
        List<Category> categories=categoryMapper.selectAll(page,size);
        pageEntity.setData(categories);
        //获取总数
        Long total=categoryMapper.getTotal();
        pageEntity.setTotal(total);
        return pageEntity;
    }

    @Override
    public Category getCategory(Integer categoryId) {
        return categoryMapper.selectById(categoryId);
    }

    @Override
    public String addCategory(Category category) {
        String categoryName=category.getCategoryName();
        Integer id=categoryMapper.getIdByName(categoryName);
        if (id==null){
       Integer i=categoryMapper.insert(category);
       if (i>0){
           String msg=String.format("添加分类成功");
           return msg;
       }else {
           String msg=String.format("添加分类失败");
           return msg;
       }
        }else {
            String msg=String.format("分类名已存在,请不要重复添加,谢谢");
            return msg;
        }
    }

    @Override
    public String updateCategory(Category category) {
        String name=category.getCategoryName();
        Integer id=categoryMapper.getIdByName(name);
        if (id==null){
        Integer i=categoryMapper.update(category);
        if (i>0){
            String msg=String.format("修改成功");
            return msg;
        }
        String msg=String.format("修改失败");
        return msg;
    }
        String msg=String.format("修改失败,分类名称已存在");
        return msg;
    }

    @Override
    public String deleteCategory(Integer categoryId) {
        //先查询此id是否被使用
        List<Product> products=productMapper.selectByCategoryId(categoryId);
        //未使用就删除
        if (products.size()<1){
          Integer i=categoryMapper.deleteById(categoryId);
          if (i>0){
              String msg=String.format("删除成功");
              return msg;
          }
          String msg=String.format("删除失败");
        }
          String msg=String.format("该分类名被使用,删除失败");
          return msg;
    }
}
