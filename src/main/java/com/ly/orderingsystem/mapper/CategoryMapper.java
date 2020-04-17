package com.ly.orderingsystem.mapper;

import com.ly.orderingsystem.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface CategoryMapper {
   Integer getIdByName(String categoryName);

   List<Category> selectAll(Integer page, Integer size);

   Long getTotal();

   Category selectById(Integer categoryId);

   Integer insert(Category category);

   Integer update(Category category);

   Integer deleteById(Integer categoryId);

}
