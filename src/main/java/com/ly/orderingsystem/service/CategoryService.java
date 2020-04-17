package com.ly.orderingsystem.service;

import com.ly.orderingsystem.entity.Category;
import com.ly.orderingsystem.model.Page;

public interface CategoryService {
    Page getCategorys(Integer page, Integer size);

    Category getCategory(Integer categoryId);

    String addCategory(Category category);


    String updateCategory(Category category);

    String deleteCategory(Integer categoryId);
}
